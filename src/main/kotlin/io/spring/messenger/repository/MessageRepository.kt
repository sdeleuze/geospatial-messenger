package io.spring.messenger.repository


import cz.jirutka.spring.data.jdbc.BaseJdbcRepository
import cz.jirutka.spring.data.jdbc.RowUnmapper
import cz.jirutka.spring.data.jdbc.TableDescription
import io.spring.messenger.domain.Message
import org.postgis.PGbox2d
import org.postgis.PGgeometry
import org.postgis.Point
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
open class MessageRepository : BaseJdbcRepository<Message, Long>(mapper(), unmapper(), TableDescription("messages", "id")) {

    open fun findByBoundingBox(box: PGbox2d): List<Message>
        = jdbcOperations.query("""SELECT * FROM ${getTableDesc().tableName}
                                  WHERE location &&
                                  ST_MakeEnvelope(${box.llb.x}, ${box.llb.y}, ${box.urt.x}, ${box.urt.y}
                                  , 4326)""", mapper())

    override fun <S : Message> postCreate(entity: S, generatedId: Number?): S {
        if (generatedId != null) entity.id = generatedId.toInt()
        return entity
    }
}

private fun mapper() = RowMapper<Message> {
    rs, rowNum -> Message(
        rs.getString("content"),
        rs.getString("author"),
        (rs.getObject("location") as PGgeometry?)?.geometry as Point?,
        rs.getInt("id"))
}

private fun unmapper() = RowUnmapper<Message> { m ->
    val map = mutableMapOf(Pair("id", m.id), Pair("content", m.content), Pair("author", m.author))
    if (m.location != null) {
        m.location!!.srid = 4326
        map["location"] = PGgeometry(m.location)
    }
    map
}