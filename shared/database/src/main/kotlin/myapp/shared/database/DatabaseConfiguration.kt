package myapp.shared.database

import com.mchange.v2.c3p0.ComboPooledDataSource
import javax.sql.DataSource

data class DatabaseConfiguration (
    val url: String,
    val username: String,
    val password: String,
    ) {
    fun createDataSource(): DataSource {
        val dataSource = ComboPooledDataSource()

        dataSource.jdbcUrl = url
        dataSource.user = username
        dataSource.password = password

        return dataSource
    }
}
