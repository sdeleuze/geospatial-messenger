package io.spring.messenger

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.jetbrains.exposed.sql.Database
import org.postgis.geojson.PostGISModule
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import javax.sql.DataSource

@SpringBootApplication
open class Application {

    @Bean open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder
        = Jackson2ObjectMapperBuilder().modulesToInstall(PostGISModule(), KotlinModule())

    @Bean open fun db(dataSource: DataSource) = Database.connect(dataSource)

    @Bean open fun init(db: Database, ur: UserRepository, mr: MessageRepository) = CommandLineRunner {
        ur.createTable()
        mr.createTable()
        mr.deleteAll()
        ur.deleteAll()

        ur.create(User("swhite", "Skyler", "White"))
        ur.create(User("jpinkman", "Jesse", "Pinkman"))
        ur.create(User("wwhite", "Walter", "White"))
        ur.create(User("sgoodman", "Saul", "Goodman"))
        mr.create(Message("This is a test!", "swhite"))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
