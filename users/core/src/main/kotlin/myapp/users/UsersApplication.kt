package myapp.users

class UsersApplication(
    private val repository: UsersRepository
) {
    fun findAll(): List<User> {
        return repository.findAll()
    }

    fun findById(id: Int): User? {
        return repository.findById(id)
    }

    fun create(user: UserModel): User {
        return repository.create(user)
    }

    fun delete(id: Int) {
        repository.delete(id)
    }
}