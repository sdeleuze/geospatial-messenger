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
        val jbauer = User("jbauer", "Jack", "Bauer")
        val cobrian = User("cobrian", "Chloe", "O'Brian")
        val kbauer = User("kbauer", "Kim", "Bauer")
        val dpalmer = User("dpalmer", "David", "Palmer")
        val mdessler = User("mdessler", "Michelle", "Dessler")

        if(userRepository.count() == 0L) {
            userRepository.create(jbauer)
            userRepository.create(cobrian)
            userRepository.create(kbauer)
            userRepository.create(dpalmer)
            userRepository.create(mdessler)
        }

        if(messageRepository.count() == 0L) {
            messageRepository.create(Message("This is a test!", jbauer))
        }
    }

}