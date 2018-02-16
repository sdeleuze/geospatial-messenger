package io.spring.messenger

import com.fasterxml.jackson.databind.ObjectMapper
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
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext

import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.request.RequestDocumentation.*
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class UserControllerTests {

    @Rule @JvmField final val restDoc =         JUnitRestDocumentation("build/generated-snippets")
    @Autowired lateinit   var context:            WebApplicationContext
    @Autowired lateinit   var userRepository:     UserRepository
    @Autowired lateinit   var messageRepository:  MessageRepository
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

     @Test fun createUser() {
        document.snippets(
            requestFields(
                fieldWithPath("userName").description("The user username"),
                fieldWithPath("firstName").description("The user first name"),
                fieldWithPath("lastName").description("The user last name"),
                fieldWithPath("location").optional().description("Optional, the user location (latitude, longitude)")
            )
        )
        var skyler = User("swhite", "Skyler", "White", Point(0.0, 0.0))
        mockMvc.perform(post("/user")
                .content(mapper.writeValueAsString(skyler))
                .contentType(APPLICATION_JSON_UTF8)
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated)
    }

    @Test fun listUsers() {
        userRepository.create(User("swhite", "Skyler", "White"))
        userRepository.create(User("jpinkman", "Jesse", "Pinkman", Point(0.0, 0.0)))

        document.snippets(
            responseFields(
                fieldWithPath("[].userName").description("The user username"),
                fieldWithPath("[].firstName").description("The user first name"),
                fieldWithPath("[].lastName").description("The user last name"),
                fieldWithPath("[].location").optional().description("Optional, the user location (latitude, longitude)")
            )
        )
        mockMvc.perform(get("/user").accept(APPLICATION_JSON_UTF8)).andExpect(status().isOk)
    }

    @Test fun findUsersByBoundingBox() {
        userRepository.create(User("swhite", "Skyler", "White", Point(0.0, 0.0)))
        userRepository.create(User("jpinkman", "Jesse", "Pinkman", Point(1.0, 1.0)))
        document.snippets(
             pathParameters(
                parameterWithName("xMin").description("The latitude of the lower-left corner"),
                parameterWithName("yMin").description("The longitude of the lower-left corner"),
                parameterWithName("xMax").description("The latitude of the upper-left corner"),
                parameterWithName("yMax").description("The longitude of the upper-left corner")
             ),
            responseFields(
                fieldWithPath("[].userName").description("The user username"),
                fieldWithPath("[].firstName").description("The user first name"),
                fieldWithPath("[].lastName").description("The user last name"),
                fieldWithPath("[].location").optional().description("Optional, the user location (latitude, longitude)")
            )
        )
        mockMvc.perform(get("/user/bbox/{xMin},{yMin},{xMax},{yMax}", -1, -1, 2, 2)
                .accept(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk)
    }

     @Test fun updateUserLocation() {
         userRepository.create(User("swhite", "Skyler", "White", Point(0.0, 0.0)))
         document.snippets(
             pathParameters(
                parameterWithName("userName").description("The user username"),
                parameterWithName("x").description("The new location latitude"),
                parameterWithName("y").description("The new location latitude")
             )
        )
        mockMvc.perform(put("/user/{userName}/location/{x},{y}", "swhite", 1.0, 1.0))
                .andExpect(status().isNoContent)
    }

}
