package myapp.users

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize(`as` = User::class)
interface User {
    val id: Int
    val name: String
    val lastName: String
    val email: String
    val password: String
}