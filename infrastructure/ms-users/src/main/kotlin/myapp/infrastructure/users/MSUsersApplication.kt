package myapp.infrastructure.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication(scanBasePackages = ["myapp"])
@ConfigurationPropertiesScan
class MSUsersApplication

fun main(args: Array<String>) {
    SpringApplication.run(MSUsersApplication::class.java, *args)
}

