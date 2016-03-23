package io.spring.messenger.repository

import io.spring.messenger.domain.User
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.stereotype.Repository

@Repository
open class UserRepository {

    val users = mutableListOf<User>()

    open fun create(user: User) = users.add(user)

    open fun updateLocation(userName:String, location: Point) { }

    open fun findAll() = users

    open fun findByBoundingBox(box: PGbox2d) = users

}