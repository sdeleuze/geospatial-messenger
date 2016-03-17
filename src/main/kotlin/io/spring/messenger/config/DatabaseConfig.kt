package io.spring.messenger.config

import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.exists
import org.springframework.boot.CommandLineRunner
import javax.sql.DataSource

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class DatabaseConfig {

    @Bean
    open fun db(dataSource: DataSource) = Database.connect(dataSource)

    @Bean
	open fun init(db: Database, userRepository: UserRepository, messageRepository: MessageRepository) = CommandLineRunner {
        val swhite = User("swhite", "Skyler", "White")
        val jpinkman = User("jpinkman", "Jesse", "Pinkman")
        val walter = User("wwhite", "Walter", "White")
        val sgoodman = User("sgoodman", "Saul", "Goodman")

        db.transaction {
            logger.addLogger(StdOutSqlLogger())

            if(!Users.exists()) {
                create(Users)
                userRepository.create(swhite)
                userRepository.create(jpinkman)
                userRepository.create(walter)
                userRepository.create(sgoodman)
            }

            if(!Messages.exists()) {
                create(Messages)
                messageRepository.create(Message("This is a test!", swhite.userName))
            }
        }
    }

}