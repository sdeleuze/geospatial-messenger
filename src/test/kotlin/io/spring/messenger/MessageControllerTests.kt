package io.spring.messenger

import com.fasterxml.jackson.databind.ObjectMapper
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.postgis.Point
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext

import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.request.RequestDocumentation.*
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MessageControllerTests {

    @Rule @JvmField final val restDoc =           JUnitRestDocumentation("build/generated-snippets")
    @Autowired lateinit   var context:            WebApplicationContext
    @Autowired lateinit   var messageRepository:  MessageRepository
    @Autowired lateinit   var userRepository:     UserRepository
    @Autowired lateinit   var mapper:             ObjectMapper
               lateinit   var mockMvc:            MockMvc
               lateinit   var document:           RestDocumentationResultHandler

    @Before fun setUp() {
        messageRepository.deleteAll()
        userRepository.deleteAll()
        document = document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()));
        mockMvc = webAppContextSetup(this.context)
                .apply<DefaultMockMvcBuilder>(documentationConfiguration(restDoc))
                .alwaysDo<DefaultMockMvcBuilder>(document).build()
    }

    @Test fun listMessages() {
        userRepository.create(User("swhite", "Skyler", "White"))
        messageRepository.create(Message("foo", "swhite"))
        messageRepository.create(Message("bar", "swhite", Point(0.0, 0.0)))
        document.snippets(
            responseFields(
                fieldWithPath("[].id").description("The message ID"),
                fieldWithPath("[].content").description("The message content"),
                fieldWithPath("[].author").description("The message author username"),
                fieldWithPath("[].location").optional().description("Optional, the message location (latitude, longitude)")
            )
        )
        mockMvc.perform(get("/message").accept(APPLICATION_JSON_UTF8)).andExpect(status().isOk)
    }

    @Test fun createMessage() {
        userRepository.create(User("swhite", "Skyler", "White"))
        document.snippets(
            requestFields(
                fieldWithPath("content").description("The message content"),
                fieldWithPath("author").description("The message author username"),
                fieldWithPath("location").optional().description("Optional, the message location (latitude, longitude)")
            ),
             responseFields(
                fieldWithPath("id").description("The message ID"),
                fieldWithPath("content").description("The message content"),
                fieldWithPath("author").description("The message author username"),
                fieldWithPath("location").optional().description("Optional, the message location (latitude, longitude)")
            )
        )
        var message = Message("""Lorem ipsum dolor sit amet, consectetur adipiscing elit,
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
        minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
        commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
        proident, sunt in culpa qui officia deserunt mollit anim id est laborum."""
                , "swhite", Point(0.0, 0.0))
        mockMvc.perform(post("/message")
                .content(mapper.writeValueAsString(message))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated)
    }

    @Test fun findMessagesByBoundingBox() {
        userRepository.create(User("swhite", "Skyler", "White"))
        messageRepository.create(Message("foo", "swhite", Point(0.0, 0.0)))
        messageRepository.create(Message("bar", "swhite", Point(1.0, 1.0)))
        document.snippets(
            pathParameters(
                parameterWithName("xMin").description("The latitude of the lower-left corner"),
                parameterWithName("yMin").description("The longitude of the lower-left corner"),
                parameterWithName("xMax").description("The latitude of the upper-left corner"),
                parameterWithName("yMax").description("The longitude of the upper-left corner")
            ),
            responseFields(
                fieldWithPath("[].id").description("The message ID"),
                fieldWithPath("[].content").description("The message content"),
                fieldWithPath("[].author").description("The message author username"),
                fieldWithPath("[].location").optional().description("Optional, the message location (latitude, longitude)")
            )
        )
        mockMvc.perform(get("/message/bbox/{xMin},{yMin},{xMax},{yMax}", -1, -1, 2, 2)
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk)
    }

    @Test fun subscribeMessages() {
        mockMvc.perform(get("/message/subscribe")).andExpect(status().isOk)
    }

}
