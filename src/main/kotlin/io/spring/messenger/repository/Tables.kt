package io.spring.messenger.repository

import org.jetbrains.exposed.sql.Table

object Messages : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val content = text("content")
    val author = reference("author", Users.userName)
    val location = point("location").nullable()
}

object Users : Table() {
    val userName = text("user_name").primaryKey()
    val firstName = text("first_name")
    val lastName = text("last_name")
    val location = point("location").nullable()
}