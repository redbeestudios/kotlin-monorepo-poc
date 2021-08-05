package myapp.posts

import myapp.posts.intermediates.UnhydratedPost

interface PostsRepository {
    fun findAll(): List<UnhydratedPost>
    fun create(post: PostModel): UnhydratedPost
    fun findById(id: Int): UnhydratedPost?
    fun delete(id: Int)
}