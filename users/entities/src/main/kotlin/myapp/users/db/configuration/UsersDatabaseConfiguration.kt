package myapp.users.db.configuration

import myapp.shared.database.DataSourceConfiguration
import myapp.shared.database.DatabaseConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConstructorBinding
@ConfigurationProperties(prefix = "users.database")
data class UsersDatabaseConfiguration(
    override val url: String,
    override val username: String,
    override val password: String
) : DatabaseConfiguration

@Configuration
@EnableConfigurationProperties(UsersDatabaseConfiguration::class)
class UsersDataSourceConfiguration(
    usersDatabaseConfiguration: UsersDatabaseConfiguration
) : DataSourceConfiguration(usersDatabaseConfiguration) {
    var datasource = getDataSource()
}