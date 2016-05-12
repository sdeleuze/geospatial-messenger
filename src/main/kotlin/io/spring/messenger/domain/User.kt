package io.spring.messenger.domain

import org.postgis.Point

class User(
    var userName  : String,
    var firstName : String,
    var lastName  : String,
    var location  : Point? = null
)
