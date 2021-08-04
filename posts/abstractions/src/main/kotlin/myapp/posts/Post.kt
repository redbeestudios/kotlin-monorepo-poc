package myapp.posts

import myapp.users.User

interface Post {
    val id: Int
    val author: User
    val content: String
}