package myapp.posts.db.schemas

import myapp.posts.db.entities.PostEntity
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Posts : Table<PostEntity>("posts") {
    val id = int("id").primaryKey().bindTo { it.id }
    val content = varchar("content").bindTo { it.content }
    val author = int("author").bindTo { it.author }
}

val Database.posts get() = this.sequenceOf(Posts)
