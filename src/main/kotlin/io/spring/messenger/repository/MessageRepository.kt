package io.spring.messenger.repository

import com.nurkiewicz.jdbcrepository.JdbcRepository
import com.nurkiewicz.jdbcrepository.RowUnmapper
import com.nurkiewicz.jdbcrepository.TableDescription
import io.spring.messenger.domain.Message
import org.postgis.PGbox2d
import org.postgis.PGgeometry
import org.postgis.Point
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
open class MessageRepository : JdbcRepository<Message, Long>(MessageRowMapper(), MessageRowUnmapper(),
        TableDescription("messages", "messages JOIN users ON messages.author = users.user_name", "id")) {

    open fun findByBoundingBox(box: PGbox2d): List<Message>
        = jdbcOperations.query("""SELECT * FROM ${table.name}
                                  WHERE location &&
                                  ST_MakeEnvelope(${box.llb.x}, ${box.llb.y}, ${box.urt.x}, ${box.urt.y}
                                  , 4326)""", rowMapper)

    class MessageRowMapper : RowMapper<Message> {
        val userRowMapper = UserRepository.UserRowMaper()
        override fun mapRow(rs: ResultSet, rowNum: Int)
            = Message(
                rs.getString("content"),
                userRowMapper.mapRow(rs, rowNum),
                (rs.getObject("location") as PGgeometry?)?.geometry as Point?,
                rs.getLong("id"))
    }

    class MessageRowUnmapper : RowUnmapper<Message> {
        override fun mapColumns(message: Message): Map<String, Any?> {
            val map = mutableMapOf(
                    Pair("id", message.id),
                    Pair("content", message.content),
                    Pair("author", message.author?.userName)
            )
            if (message.location != null) {
                message.location!!.srid = 4326
                map["location"] = PGgeometry(message.location)
            }
            return map
        }
    }

    override fun <S : Message> postCreate(entity: S, generatedId: Number?): S {
        if (generatedId != null) entity.id = generatedId.toLong()
        return entity
    }

}
