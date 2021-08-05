package myapp.posts

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import myapp.users.User

@JsonSerialize(`as` = Post::class)
interface Post {
    val id: Int
    val author: User
    val content: String
}