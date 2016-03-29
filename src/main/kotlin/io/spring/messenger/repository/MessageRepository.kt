package io.spring.messenger.repository

import io.spring.messenger.Messages
import io.spring.messenger.domain.Message
import io.spring.messenger.within
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.postgis.PGbox2d
import org.springframework.stereotype.Repository

@Repository
open class MessageRepository(val db: Database) {

    open fun createTable() = db.transaction {
        create(Messages)
    }

    open fun create(m: Message) = db.transaction {
        m.id = Messages.insert(toRow(m)).get(Messages.id)
        m
    }

    open fun findAll() = db.transaction {
        Messages.selectAll().map { fromRow(it) }
    }

    open fun findByBoundingBox(box: PGbox2d) = db.transaction {
        Messages.select { Messages.location within box }.map { fromRow(it) }
    }

    open fun deleteAll() = db.transaction {
        Messages.deleteAll()
    }

    fun toRow(m: Message): Messages.(UpdateBuilder<*>) -> Unit = {
        if (m.id != null) it[id] = m.id
        it[content] = m.content
        it[author] = m.author
        it[location] = m.location
    }

    fun fromRow(r: ResultRow) =
        Message(r[Messages.content], r[Messages.author], r[Messages.location], r[Messages.id])

}