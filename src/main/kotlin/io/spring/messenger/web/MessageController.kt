package io.spring.messenger.web

import io.spring.messenger.domain.Message
import io.spring.messenger.repository.MessageRepository
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController @Autowired constructor(val repository: MessageRepository) {

    @PostMapping
    fun create(@RequestBody message: Message) = repository.create(message)

    @GetMapping
    fun findMessages() = repository.findAll()

    @GetMapping("/bbox/{xMin},{yMin},{xMax},{yMax}")
    fun findByBoundingBox(@PathVariable xMin:Double, @PathVariable yMin:Double,
                          @PathVariable xMax:Double, @PathVariable yMax:Double)
            = repository.findByBoundingBox(PGbox2d(Point(xMin, yMin), Point(xMax, yMax)))

   }