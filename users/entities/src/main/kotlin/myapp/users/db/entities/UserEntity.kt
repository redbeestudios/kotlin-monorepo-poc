package myapp.users.db.entities

import myapp.users.User
import org.ktorm.entity.Entity

interface UserEntity : Entity<UserEntity>, User {
    companion object : Entity.Factory<UserEntity>()
}
