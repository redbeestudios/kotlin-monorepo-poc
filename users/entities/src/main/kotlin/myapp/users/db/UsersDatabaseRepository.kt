package myapp.users.db

import myapp.shared.database.DatabaseRepository
import myapp.users.User
import myapp.users.UserModel
import myapp.users.UsersRepository
import myapp.users.db.configuration.UsersDataSourceConfiguration
import myapp.users.db.entities.UserEntity
import myapp.users.db.schemas.users
import org.ktorm.dsl.eq
import org.ktorm.dsl.inList
import org.ktorm.entity.add
import org.ktorm.entity.filter
import org.ktorm.entity.removeIf
import org.ktorm.entity.toList
import org.springframework.stereotype.Service

@Service
class UsersDatabaseRepository(configuration: UsersDataSourceConfiguration) : DatabaseRepository(configuration.datasource),
    UsersRepository {
    override fun findAll(): List<UserEntity> {
        return database.users.toList()
    }

    override fun findById(id: Int): UserEntity? {
        return database.users.filter { it.id eq id }.toList().getOrNull(0)
    }

    override fun findByIds(ids: List<Int>): List<User> {
        return database.users.filter { it.id inList ids }.toList()
    }

    override fun create(user: UserModel): User {
        val entity = UserEntity()
        entity["name"] = user.name
        entity["lastName"] = user.lastName
        entity["email"] = user.email
        entity["password"] = user.password
        database.users.add(entity)
        return entity
    }

    override fun delete(id: Int) {
        database.users.removeIf { it.id eq id }
    }
}