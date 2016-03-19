package io.spring.messenger

import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(Application::class))
@WebAppConfiguration
class UserControllerTests {

    @Autowired lateinit var context:            WebApplicationContext
    @Autowired lateinit var userRepository:     UserRepository
    @Autowired lateinit var messageRepository:  MessageRepository
               lateinit var mockMvc:            MockMvc

    @Before fun setUp() {
        messageRepository.deleteAll()
        userRepository.deleteAll()
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build()
    }

    @Test fun findUsers() {
        mockMvc.perform(get("/user").accept(APPLICATION_JSON)).andExpect(status().isOk)
    }

}
