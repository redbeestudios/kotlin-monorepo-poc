package myapp.posts.db

import myapp.posts.Post
import myapp.posts.PostImpl
import myapp.posts.PostModel
import myapp.posts.PostsRepository
import myapp.posts.db.configuration.PostsDataSourceConfiguration
import myapp.posts.db.entities.PostEntity
import myapp.posts.db.schemas.posts
import myapp.shared.database.DatabaseRepository
import myapp.users.User
import myapp.users.UsersRepository
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.filter
import org.ktorm.entity.removeIf
import org.ktorm.entity.toList
import kotlin.streams.toList

class PostsDatabaseRepository(
    private val postsDataSourceConfiguration: PostsDataSourceConfiguration,
    private val usersRepository: UsersRepository
) : DatabaseRepository(postsDataSourceConfiguration.datasource), PostsRepository {
    override fun findAll(): List<Post> {
        val postEntities = database.posts.toList()
        val users = usersRepository.findByIds(postEntities.stream().map { it.author }.toList())
        return postEntities
            .stream()
            .map { post -> hydratePostEntity(
                post,
                users.first { user -> user.id == post.author }
            )}
            .toList()
    }

    override fun create(post: PostModel): Post {
        val user = findUser(post.author)

        val entity = PostEntity()
        entity["content"] = post.content
        entity["author"] = post.author
        database.posts.add(entity)
        return hydratePostEntity(entity, user)
    }

    override fun findById(id: Int): Post? {
        val entity = database.posts.filter { it.id eq id }.toList().getOrNull(0) ?: return null
        return hydratePostEntity(entity, findUser(entity.author))
    }

    override fun delete(id: Int) {
        database.posts.removeIf { it.id eq id }
    }

    private fun findUser(id: Int): User {
        return usersRepository.findById(id) ?: throw Exception("User $id not found")
    }

    private fun hydratePostEntity(postEntity: PostEntity, user: User): Post {
        return PostImpl(postEntity.id, user, postEntity.content)
    }
}