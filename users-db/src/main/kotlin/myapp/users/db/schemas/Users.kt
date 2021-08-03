package myapp.users.db.schemas

import myapp.users.db.entities.UserEntity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Users : Table<UserEntity>("users") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val lastName = varchar("lastName").bindTo { it.lastName }
    val email = varchar("email").bindTo { it.email }
    val password = varchar("password").bindTo { it.password }
}