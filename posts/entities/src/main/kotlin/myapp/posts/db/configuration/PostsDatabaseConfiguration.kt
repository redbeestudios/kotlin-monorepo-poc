package myapp.posts.db.configuration

import myapp.shared.database.DataSourceConfiguration
import myapp.shared.database.DatabaseConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConstructorBinding
@ConfigurationProperties(prefix = "posts.database")
data class PostsDatabaseConfiguration(
    override val url: String,
    override val username: String,
    override val password: String
) : DatabaseConfiguration

@Configuration
@EnableConfigurationProperties(PostsDatabaseConfiguration::class)
class PostsDataSourceConfiguration(
    postsDatabaseConfiguration: PostsDatabaseConfiguration
) : DataSourceConfiguration(postsDatabaseConfiguration) {
    var datasource = getDataSource()
}