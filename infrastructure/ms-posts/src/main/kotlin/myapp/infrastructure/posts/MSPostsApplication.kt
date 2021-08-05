package myapp.infrastructure.posts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication(scanBasePackages = ["myapp"])
@ConfigurationPropertiesScan
class MSPostsApplication

fun main(args: Array<String>) {
    SpringApplication.run(MSPostsApplication::class.java, *args)
}

