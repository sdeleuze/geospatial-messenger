package io.spring.messenger.web

import io.spring.messenger.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController @Autowired constructor(val repository: MessageRepository) {

    @GetMapping
    fun findMessages() = repository.findAll()

}