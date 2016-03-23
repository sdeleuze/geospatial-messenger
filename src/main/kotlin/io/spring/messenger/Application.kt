package io.spring.messenger

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.postgis.Point
import org.postgis.geojson.PostGISModule
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class Application {

    @Bean open fun objectMapper(): ObjectMapper {
        val mapper:ObjectMapper = Jackson2ObjectMapperBuilder().modulesToInstall(PostGISModule(), KotlinModule()).build()
        mapper.setSerializationInclusion(Include.NON_NULL)
        return mapper
    }

    @Bean open fun init(ur: UserRepository, mr: MessageRepository) = CommandLineRunner {
        ur.create(User("swhite", "Skyler", "White"))
        ur.create(User("jpinkman", "Jesse", "Pinkman"))
        ur.create(User("wwhite", "Walter", "White"))
        ur.create(User("sgoodman", "Saul", "Goodman"))
        mr.create(Message("This is a test!", "swhite", Point(597737.56119008, 5833062.5024984), 1))
        mr.create(Message("This is a test!", "swhite", Point(704137.90456304, 5740726.5723299), 2))
        mr.create(Message("This is a test!", "swhite", Point(1643701.8562444, 6070934.5345218), 3))
        mr.create(Message("This is a test!", "swhite", Point(1095801.2374963, 6648186.9721315), 4))
        mr.create(Message("This is a test!", "swhite", Point(190786.8225998, 6276397.2665524), 5))
        mr.create(Message("This is a test!", "swhite", Point(-391357.5848201, 7254791.2286026), 6))
        mr.create(Message("This is a test!", "swhite", Point(-391357.5848201, 5258867.5460201), 6))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
