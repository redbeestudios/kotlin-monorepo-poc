package myapp.posts

interface PostsRepository {
    fun findAll(): List<Post>
    fun create(post: PostModel): Post
    fun findById(id: Int): Post?
    fun delete(id: Int)
}