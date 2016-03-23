package io.spring.messenger.repository

import io.spring.messenger.domain.Message
import org.postgis.PGbox2d
import org.springframework.stereotype.Repository

@Repository
open class MessageRepository {

    val messages = mutableListOf<Message>()


    open fun create(m: Message) = messages.add(m)

    open fun findAll() = messages

    open fun findByBoundingBox(box: PGbox2d) = messages

}