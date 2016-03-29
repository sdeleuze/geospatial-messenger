package io.spring.messenger.web

import io.spring.messenger.domain.Message
import io.spring.messenger.repository.MessageRepository
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
@RequestMapping("/message")
class MessageController(val repository: MessageRepository) {

    val broadcaster = SseBroadcaster()

    @PostMapping @ResponseStatus(CREATED)
    fun create(@RequestBody message: Message): Message {
        val m = repository.create(message)
        broadcaster.send(m)
        return m
    }

    @GetMapping
    fun list() = repository.findAll()

    @GetMapping("/bbox/{xMin},{yMin},{xMax},{yMax}")
    fun findByBoundingBox(@PathVariable xMin:Double, @PathVariable yMin:Double,
                          @PathVariable xMax:Double, @PathVariable yMax:Double)
            = repository.findByBoundingBox(PGbox2d(Point(xMin, yMin), Point(xMax, yMax)))

    @GetMapping("/subscribe")
    fun subscribe(): SseEmitter = broadcaster.subscribe()

}