package myapp.shared.database

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

interface DatabaseConfiguration {
    val url: String
    val username: String
    val password: String
}

abstract class DataSourceConfiguration(
    private val databaseConfiguration: DatabaseConfiguration
) {
    protected fun getDataSource(): DataSource {
        val dataSource = ComboPooledDataSource()

        dataSource.jdbcUrl = databaseConfiguration.url
        dataSource.user = databaseConfiguration.username
        dataSource.password = databaseConfiguration.password

        return dataSource
    }
}
