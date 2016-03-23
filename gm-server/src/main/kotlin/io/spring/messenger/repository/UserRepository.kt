package io.spring.messenger.repository

import io.spring.messenger.Users
import io.spring.messenger.domain.User
import io.spring.messenger.within
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
open class UserRepository @Autowired constructor(val db: Database) {

    open fun createTable() = db.transaction {
        create(Users)
    }

    open fun create(user: User) = db.transaction {
            Users.insert( toRow(user) )
    }

    open fun updateLocation(userName:String, location: Point) = db.transaction {
        location.srid = 4326
        Users.update({Users.userName eq userName}) { it[Users.location] = location}
    }

    open fun findAll() = db.transaction {
        Users.selectAll().map { fromRow(it) }
    }

    open fun findByBoundingBox(box: PGbox2d) = db.transaction {
        Users.select { Users.location within box }.map { fromRow(it) }
    }

    open fun deleteAll() = db.transaction {
        Users.deleteAll()
    }

    fun toRow(u: User): Users.(UpdateBuilder<*>) -> Unit = {
        it[userName] = u.userName
        it[firstName] = u.firstName
        it[lastName] = u.lastName
        it[location] = u.location
    }

    fun fromRow(r: ResultRow) =
        User(r[Users.userName], r[Users.firstName], r[Users.lastName], r[Users.location])

}