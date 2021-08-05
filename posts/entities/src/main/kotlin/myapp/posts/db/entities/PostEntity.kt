package myapp.posts.db.entities

import myapp.posts.intermediates.UnhydratedPost
import org.ktorm.entity.Entity

interface PostEntity : Entity<PostEntity>, UnhydratedPost {
    companion object : Entity.Factory<PostEntity>()
}