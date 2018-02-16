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

interface UserRepository: CrudRepository<User, String>

@Repository
@Transactional // Should be at @Service level in real applications
class DefaultUserRepository: UserRepository {

    override fun createTable() = SchemaUtils.create(Users)

    override fun create(m: User): User {
        Users.insert(toRow(m))
        return m
    }

    override fun updateLocation(userName:String, location: Point) {
        location.srid = 4326
        Users.update({Users.userName eq userName}) { it[Users.location] = location}
    }

    override fun findAll() = Users.selectAll().map { fromRow(it) }

    override fun findByBoundingBox(box: PGbox2d) = Users.select { Users.location within box }.map { fromRow(it) }

    override fun deleteAll() = Users.deleteAll()

    private fun toRow(u: User): Users.(UpdateBuilder<*>) -> Unit = {
        it[userName] = u.userName
        it[firstName] = u.firstName
        it[lastName] = u.lastName
        it[location] = u.location
    }

    private fun fromRow(r: ResultRow) =
        User(r[Users.userName], r[Users.firstName], r[Users.lastName], r[Users.location])

}