package myapp.posts

class PostsApplication (
    private val postsRepository: PostsRepository
 ) {
    fun findAll(): List<Post> {
        return postsRepository.findAll()
    }

    fun create(post: PostModel): Post {
        return postsRepository.create(post)
    }

    fun findById(id: Int): Post? {
        return postsRepository.findById(id)
    }

    fun delete(id: Int) {
        return postsRepository.delete(id)
    }
}