package io.spring.messenger.domain

import org.postgis.Point
import org.springframework.data.annotation.Id

data class User(
    @Id var userName  : String,
        var firstName : String,
        var lastName  : String,
        var location  : Point? = null
)
