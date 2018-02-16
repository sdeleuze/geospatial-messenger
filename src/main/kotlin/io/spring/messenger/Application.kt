package io.spring.messenger

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.ObjectMapper
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.postgis.geojson.PostGISModule
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@SpringBootApplication
@EnableTransactionManagement
class Application {

    @Bean
    fun objectMapper(): ObjectMapper {
        val mapper:ObjectMapper = Jackson2ObjectMapperBuilder().modulesToInstall(PostGISModule()).build()
        mapper.setSerializationInclusion(Include.NON_NULL)
        return mapper
    }

    @Bean
    fun transactionManager(dataSource: DataSource) = SpringTransactionManager(dataSource)

    @Bean // PersistenceExceptionTranslationPostProcessor with proxyTargetClass=false, see https://github.com/spring-projects/spring-boot/issues/1844
    fun persistenceExceptionTranslationPostProcessor() = PersistenceExceptionTranslationPostProcessor()

    @Bean
    fun init(ur: UserRepository, mr: MessageRepository) = CommandLineRunner {
        ur.createTable()
        mr.createTable()
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
