package myapp.posts.rest.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "users.rest.client")
data class UsersRestClientConfiguration(
    val url: String
)