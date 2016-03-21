package io.spring.messenger.domain

import org.postgis.Point
import org.springframework.data.annotation.Id

data class Message(
        var content  : String,
        var author   : String,
        var location : Point? = null,
    @Id var id       : Int?   = null
)

