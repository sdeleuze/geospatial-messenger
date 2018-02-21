package io.spring.messenger

import com.fasterxml.jackson.databind.ObjectMapper
import io.spring.messenger.domain.Message
import io.spring.messenger.domain.User
import io.spring.messenger.repository.MessageRepository
import io.spring.messenger.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.postgis.Point
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MessageControllerTests {

    @Autowired lateinit   var messageRepository:  MessageRepository
    @Autowired lateinit   var userRepository:     UserRepository
    @Autowired lateinit   var mapper:             ObjectMapper
    @Autowired lateinit   var mockMvc:            MockMvc

    @Before fun setUp() {
        messageRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test fun listMessages() {
        userRepository.create(User("swhite", "Skyler", "White"))
        messageRepository.create(Message("foo", "swhite"))
        messageRepository.create(Message("bar", "swhite", Point(0.0, 0.0)))
        mockMvc.perform(get("/message").accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk)
                .andDo(document("{method-name}",responseFields(
                        fieldWithPath("[].id").description("The message ID"),
                        fieldWithPath("[].content").description("The message content"),
                        fieldWithPath("[].author").description("The message author username"),
                        subsectionWithPath("[].location").optional().description("Optional, the message location (latitude, longitude)")
                )))
    }

    @Test fun createMessage() {
        userRepository.create(User("swhite", "Skyler", "White"))
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
                .andDo(document("{method-name}",
                        requestFields(
                                fieldWithPath("content").description("The message content"),
                                fieldWithPath("author").description("The message author username"),
                                subsectionWithPath("location").optional().description("Optional, the message location (latitude, longitude)")
                        ),
                        responseFields(
                                fieldWithPath("id").description("The message ID"),
                                fieldWithPath("content").description("The message content"),
                                fieldWithPath("author").description("The message author username"),
                                subsectionWithPath("location").optional().description("Optional, the message location (latitude, longitude)")
                        ) ))
    }

    @Test fun findMessagesByBoundingBox() {
        userRepository.create(User("swhite", "Skyler", "White"))
        messageRepository.create(Message("foo", "swhite", Point(0.0, 0.0)))
        messageRepository.create(Message("bar", "swhite", Point(1.0, 1.0)))
        mockMvc.perform(get("/message/bbox/{xMin},{yMin},{xMax},{yMax}", -1, -1, 2, 2)
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk)
                .andDo(document("{method-name}",
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
                                subsectionWithPath("[].location").optional().description("Optional, the message location (latitude, longitude)")
                        )))
    }

    @Test fun subscribeMessages() {
        mockMvc.perform(get("/message/subscribe")).andExpect(status().isOk)
    }

}
