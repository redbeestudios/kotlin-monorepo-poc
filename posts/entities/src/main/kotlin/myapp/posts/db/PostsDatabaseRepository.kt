package myapp.posts.db

import myapp.posts.PostModel
import myapp.posts.PostsRepository
import myapp.posts.db.configuration.PostsDataSourceConfiguration
import myapp.posts.db.entities.PostEntity
import myapp.posts.db.schemas.posts
import myapp.posts.intermediates.UnhydratedPost
import myapp.shared.database.DatabaseRepository
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.filter
import org.ktorm.entity.removeIf
import org.ktorm.entity.toList
import org.springframework.stereotype.Service

@Service
class PostsDatabaseRepository(
    postsDataSourceConfiguration: PostsDataSourceConfiguration
) : DatabaseRepository(postsDataSourceConfiguration.datasource), PostsRepository {
    override fun findAll(): List<UnhydratedPost> {
        return database.posts.toList()
    }

    override fun create(post: PostModel): UnhydratedPost {
        val entity = PostEntity()
        entity["content"] = post.content
        entity["author"] = post.author
        database.posts.add(entity)
        return entity
    }

    override fun findById(id: Int): UnhydratedPost? {
        return database.posts.filter { it.id eq id }.toList().getOrNull(0)
    }

    override fun delete(id: Int) {
        database.posts.removeIf { it.id eq id }
    }
}