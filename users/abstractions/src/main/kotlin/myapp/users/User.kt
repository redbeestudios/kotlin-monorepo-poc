package myapp.users

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize(`as` = User::class)
@JsonDeserialize(`as` = UserImpl::class)
interface User {
    val id: Int
    val name: String
    val lastName: String
    val email: String
    val password: String
}

data class UserImpl(
    override val id: Int,
    override val name: String,
    override val lastName: String,
    override val email: String,
    override val password: String
) : User