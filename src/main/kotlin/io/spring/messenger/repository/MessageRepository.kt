package io.spring.messenger.repository

import io.spring.messenger.Messages
import io.spring.messenger.domain.Message
import io.spring.messenger.within
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.postgis.PGbox2d
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
open class MessageRepository @Autowired constructor(val db: Database) {

    open fun createTable() = db.transaction {
        create(Messages)
    }

    open fun create(m: Message) = db.transaction {
        m.id = Messages.insert(map(m)).get(Messages.id)
        m
    }

    open fun findAll() = db.transaction {
        unmap(Messages.selectAll())
    }

    open fun findByBoundingBox(box: PGbox2d) = db.transaction {
        unmap(Messages.select { Messages.location within box })
    }

    open fun deleteAll() = db.transaction {
        Messages.deleteAll()
    }

    private fun map(m: Message): Messages.(UpdateBuilder<*>) -> Unit = {
        if (m.id != null) it[id] = m.id
        it[content] = m.content
        it[author] = m.author
        it[location] = m.location
    }

    private fun unmap(rows: SizedIterable<ResultRow>): List<Message> =
            rows.map { Message(it[Messages.content], it[Messages.author], it[Messages.location], it[Messages.id]) }

}