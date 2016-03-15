package io.spring.messenger.domain

import org.postgis.Point
import org.springframework.data.annotation.Id

data class MessageWithAuthor(
        var content: String,
        var author: User,
        var location: Point? = null,
        @Id var id: Long? = null
)