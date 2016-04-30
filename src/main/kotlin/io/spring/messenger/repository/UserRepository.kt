package io.spring.messenger.repository

import io.spring.messenger.Users
import io.spring.messenger.domain.User
import io.spring.messenger.within
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
open class UserRepository() {

    open fun createTable() = SchemaUtils.create(Users)

    open fun create(user: User) = Users.insert( toRow(user) )

    open fun updateLocation(userName:String, location: Point) = {
        location.srid = 4326
        Users.update({Users.userName eq userName}) { it[Users.location] = location}
    }

    open fun findAll() = Users.selectAll().map { fromRow(it) }

    open fun findByBoundingBox(box: PGbox2d) = Users.select { Users.location within box }.map { fromRow(it) }

    open fun deleteAll() = Users.deleteAll()

    fun toRow(u: User): Users.(UpdateBuilder<*>) -> Unit = {
        it[userName] = u.userName
        it[firstName] = u.firstName
        it[lastName] = u.lastName
        it[location] = u.location
    }

    fun fromRow(r: ResultRow) =
        User(r[Users.userName], r[Users.firstName], r[Users.lastName], r[Users.location])

}