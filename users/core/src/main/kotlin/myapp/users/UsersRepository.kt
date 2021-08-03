package myapp.users

interface UsersRepository {
    fun findAll(): List<User>
    fun findById(id: Int): User?
    fun create(user: UserModel): User
    fun delete(id: Int)
}