package myapp.posts

import myapp.users.User

data class PostImpl(
    override val id: Int,
    override val author: User,
    override val content: String
) : Post