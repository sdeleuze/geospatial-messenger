package io.spring.messenger.repository

import io.spring.messenger.Messages
import io.spring.messenger.domain.Message
import io.spring.messenger.within
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

interface MessageRepository: CrudRepository<Message, Int>

@Repository
@Transactional // Should be at @Service level in real applications
class DefaultMessageRepository : MessageRepository {

    override fun createTable() = SchemaUtils.create(Messages)

    override  fun create(m: Message): Message {
        m.id = Messages.insert(toRow(m))[Messages.id]
        return m
    }

    override fun findAll() = Messages.selectAll().map { fromRow(it) }

    override fun findByBoundingBox(box: PGbox2d) = Messages.select { Messages.location within box }.map { fromRow(it) }

    override fun updateLocation(userName:Int, location: Point) {
        location.srid = 4326
        Messages.update({ Messages.id eq userName }) { it[Messages.location] = location}
    }

    override fun deleteAll() = Messages.deleteAll()

    private fun toRow(m: Message): Messages.(UpdateBuilder<*>) -> Unit = {
        if (m.id != null) it[id] = m.id
        it[content] = m.content
        it[author] = m.author
        it[location] = m.location
    }

    private fun fromRow(r: ResultRow) =
        Message(r[Messages.content], r[Messages.author], r[Messages.location], r[Messages.id])

}