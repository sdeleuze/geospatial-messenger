package io.spring.messenger

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.ObjectMapper
import com.md.exposed.ExposedTables
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.postgis.geojson.PostGISModule
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class Application {

    @Bean
    fun objectMapper(): ObjectMapper {
        val mapper:ObjectMapper = Jackson2ObjectMapperBuilder().modulesToInstall(PostGISModule()).build()
        mapper.setSerializationInclusion(Include.NON_NULL)
        return mapper
    }

    @Bean // PersistenceExceptionTranslationPostProcessor with proxyTargetClass=false, see https://github.com/spring-projects/spring-boot/issues/1844
    fun persistenceExceptionTranslationPostProcessor() = PersistenceExceptionTranslationPostProcessor()

    @Bean
    fun exposedTables(): ExposedTables {
        return ExposedTables(listOf(Users, Messages))
    }

    @Bean
    fun init(ur: UserRepository, mr: MessageRepository) = CommandLineRunner {
        mr.deleteAll()
        ur.deleteAll()

        ur.create(User("swhite", "Skyler", "White"))
        ur.create(User("jpinkman", "Jesse", "Pinkman"))
        ur.create(User("wwhite", "Walter", "White"))
        ur.create(User("sgoodman", "Saul", "Goodman"))
        mr.create(Message("I AM THE ONE WHO KNOCKS!", "wwhite"))
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
