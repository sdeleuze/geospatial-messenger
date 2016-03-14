package io.spring.messenger.web

import io.spring.messenger.repository.MessageRepository
import org.postgis.PGbox2d
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController @Autowired constructor(val repository: MessageRepository) {

    @GetMapping
    fun findMessages() = repository.findAll()

    /**
     * {@code box} parameter should use this format: xmin%20ymin,xmax%20ymax
     */
    @GetMapping("/bbox/{box}")
    fun findByBoundingBox(@PathVariable box:String)
            = repository.findByBoundingBox(PGbox2d("BOX($box)"))

}