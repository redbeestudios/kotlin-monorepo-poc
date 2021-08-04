package myapp.users

import org.springframework.stereotype.Service

@Service
class UsersApplication(
    private val repository: UsersRepository
) {
    fun findAll(): List<User> {
        return repository.findAll()
    }

    fun findById(id: Int): User? {
        return repository.findById(id)
    }

    fun findByIds(ids: List<Int>): List<User?> {
        return repository.findByIds(ids)
    }

    fun create(user: UserModel): User {
        return repository.create(user)
    }

    fun delete(id: Int) {
        repository.delete(id)
    }
}