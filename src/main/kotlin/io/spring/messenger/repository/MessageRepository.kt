package io.spring.messenger.repository

import io.spring.messenger.Messages
import io.spring.messenger.domain.Message
import io.spring.messenger.within
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.postgis.PGbox2d
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional // Should be at @Service level in real applications
class MessageRepository() {

    fun createTable() = SchemaUtils.create(Messages)

    fun create(m: Message): Message {
        m.id = Messages.insert(toRow(m)).get(Messages.id)
        return m
    }

    fun findAll() = Messages.selectAll().map { fromRow(it) }

    fun findByBoundingBox(box: PGbox2d) = Messages.select { Messages.location within box }.map { fromRow(it) }

    fun deleteAll() = Messages.deleteAll()

    fun toRow(m: Message): Messages.(UpdateBuilder<*>) -> Unit = {
        if (m.id != null) it[id] = m.id
        it[content] = m.content
        it[author] = m.author
        it[location] = m.location
    }

    fun fromRow(r: ResultRow) =
        Message(r[Messages.content], r[Messages.author], r[Messages.location], r[Messages.id])

}