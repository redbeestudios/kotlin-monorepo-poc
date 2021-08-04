package myapp.shared.database

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration("database")
data class DatabaseConfiguration (
    @Value("url") private val url: String,
    @Value("username") private val username: String,
    @Value("password") private val password: String,
    ) {

    @Bean
    fun dataSource(): DataSource {
        val dataSource = ComboPooledDataSource()

        dataSource.jdbcUrl = url
        dataSource.user = username
        dataSource.password = password

        return dataSource
    }
}
