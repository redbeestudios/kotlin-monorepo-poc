package myapp.posts

import myapp.posts.intermediates.UnhydratedPost
import myapp.users.User
import myapp.users.UsersRepository
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class PostsApplication (
    private val postsRepository: PostsRepository,
    private val usersRepository: UsersRepository
 ) {
    fun findAll(): List<Post> {
        val postEntities = postsRepository.findAll()

        if (postEntities.isEmpty()) {
            return emptyList()
        }
        val users: List<User> = usersRepository.findByIds(postEntities.stream().map { it.author }.toList())
        return postEntities
            .stream()
            .map { post -> hydratePost(
                post,
                users.first { user -> user.id == post.author }
            )}
            .toList()
    }

    fun create(post: PostModel): Post {
        val user = findUser(post.author)
        val postEntity = postsRepository.create(post)
        return hydratePost(postEntity, user)
    }

    fun findById(id: Int): Post? {
        val post = postsRepository.findById(id) ?: return null
        return hydratePost(post, findUser(post.author))
    }

    fun delete(id: Int) {
        return postsRepository.delete(id)
    }

    private fun findUser(id: Int): User {
        return usersRepository.findById(id) ?: throw Exception("User $id not found")
    }

    private fun hydratePost(post: UnhydratedPost, user: User): Post {
        return PostImpl(post.id, user, post.content)
    }
}