package myapp.shared.database

import org.ktorm.database.Database
import javax.sql.DataSource

abstract class DatabaseRepository (
    dataSource: DataSource
) {
    val database: Database = Database.connect(dataSource)
}