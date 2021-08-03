package myapp.users.domain

interface User {
    val id: Int
    val name: String
    val lastName: String
    val email: String
    val password: String
}