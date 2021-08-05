package myapp.posts.rest.client

import myapp.posts.rest.client.configuration.UsersRestClientConfiguration
import myapp.shared.restclient.RestClient
import myapp.users.User
import myapp.users.UserModel
import myapp.users.UsersRepository
import okhttp3.Request
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

@Configuration
@EnableConfigurationProperties(UsersRestClientConfiguration::class)
@Service
class UsersRestRepository(
    configuration: UsersRestClientConfiguration
) : RestClient(), UsersRepository {
    val baseUrl = configuration.url

    override fun findAll(): List<User> {
        return fetch<List<User>>(Request.Builder().url(baseUrl).build()) ?: emptyList()
    }

    override fun findById(id: Int): User? {
        return fetch<User>(Request.Builder().url("$baseUrl/$id").build())
    }

    override fun findByIds(ids: List<Int>): List<User> {
        val idsParam = ids.joinToString(",")
        return fetch<List<User>>(Request.Builder().url("$baseUrl/?ids=$idsParam").build()) ?: emptyList()
    }

    override fun create(user: UserModel): User {
        return fetch<User>(Request.Builder()
            .url(baseUrl)
            .post(requestBody(user))
            .build()
        ) ?: throw Exception("Couldn't receive a user while creating through HTTP, operation status unknown")
    }

    override fun delete(id: Int) {
        val response = client.newCall(Request.Builder().url(baseUrl).delete().build()).execute()
        ensureResponseIsOk(response)
    }
}