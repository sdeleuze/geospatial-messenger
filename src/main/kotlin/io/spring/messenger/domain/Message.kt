package io.spring.messenger.domain

import org.postgis.Point

data class Message(
        var content: String,
        var author: String,
        var location: Point? = null,
        var id: Int? = null
)

