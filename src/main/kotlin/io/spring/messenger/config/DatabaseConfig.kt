package io.spring.messenger.config

import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import javax.sql.DataSource

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@Configuration
open class DatabaseConfig {

    @Bean
    open fun transactionManager(dataSource: DataSource): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    @Bean
	open fun init(userRepository: UserRepository, messageRepository: MessageRepository) = CommandLineRunner {
        val swhite = User("swhite", "Skyler", "White")
        val jpinkman = User("jpinkman", "Jesse", "Pinkman")
        val walter = User("wwhite", "Walter", "White")
        val sgoodman = User("sgoodman", "Saul", "Goodman")


        if(userRepository.count() == 0L) {
            userRepository.create(swhite)
            userRepository.create(jpinkman)
            userRepository.create(walter)
            userRepository.create(sgoodman)
        }

        if(messageRepository.count() == 0L) {
            messageRepository.create(Message("This is a test!", swhite.userName))
        }
    }

}