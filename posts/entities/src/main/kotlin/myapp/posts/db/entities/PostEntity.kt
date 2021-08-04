package myapp.posts.db.entities

import myapp.posts.Post
import org.ktorm.entity.Entity

interface PostEntity : Entity<PostEntity> {
    val id: Int
    val content: String
    val author: Int
    companion object : Entity.Factory<PostEntity>()
}