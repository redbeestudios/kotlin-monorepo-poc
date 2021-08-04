package myapp.infrastructure.monolyth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication(scanBasePackages = ["myapp"])
class MonolythApplication {
    fun main(args: Array<String>) {
        SpringApplication.run(MonolythApplication::class.java, *args)
    }
}

