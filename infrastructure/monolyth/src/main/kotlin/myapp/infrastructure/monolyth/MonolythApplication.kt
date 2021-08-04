package myapp.infrastructure.monolyth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication(scanBasePackages = ["myapp"])
@ConfigurationPropertiesScan
class MonolythApplication

fun main(args: Array<String>) {
    SpringApplication.run(MonolythApplication::class.java, *args)
}

