package io.spring.messenger

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.ObjectMapper
import de.invesdwin.instrument.DynamicInstrumentationLoader
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.postgis.geojson.PostGISModule
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ImportResource
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@ImportResource(locations = arrayOf("classpath:/META-INF/ctx.spring.weaving.xml")) //make @Configurable work
open class Application {

    @Bean
    open fun objectMapper(): ObjectMapper {
        val mapper:ObjectMapper = Jackson2ObjectMapperBuilder().modulesToInstall(PostGISModule()).build()
        mapper.setSerializationInclusion(Include.NON_NULL)
        return mapper
    }

    @Bean
    open fun transactionManager(dataSource: DataSource) = SpringTransactionManager(dataSource)

    @Bean
    open fun init(ur: UserRepository, mr: MessageRepository) = CommandLineRunner {
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
    DynamicInstrumentationLoader.waitForInitialized(); //dynamically attach java agent to jvm if not already present
    DynamicInstrumentationLoader.initLoadTimeWeavingContext(); //weave all classes before they are loaded as beans
    SpringApplication.run(Application::class.java, *args)
}
