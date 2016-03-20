package io.spring.messenger.repository

import cz.jirutka.spring.data.jdbc.BaseJdbcRepository
import cz.jirutka.spring.data.jdbc.RowUnmapper
import io.spring.messenger.domain.User
import org.postgis.PGbox2d
import org.postgis.PGgeometry
import org.postgis.Point
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
open class UserRepository : BaseJdbcRepository<User, String>(mapper(), unmapper(), "\"users\"", "user_name") {

    open fun updateLocation(userName:String, location: Point): Unit {
        location.srid = 4326
        jdbcOperations.update("UPDATE ${tableDesc.tableName} SET location = '${PGgeometry(location)}' WHERE user_name = '$userName'")
    }

    open fun findByBoundingBox(box: PGbox2d): List<User>
        = jdbcOperations.query("""SELECT * FROM ${tableDesc.tableName}
                                  WHERE location &&
                                  ST_MakeEnvelope(${box.llb.x}, ${box.llb.y}, ${box.urt.x}, ${box.urt.y}
                                  , 4326)""", mapper())

}

private fun mapper() = RowMapper<User> {
    rs, rowNum -> User(
        rs.getString("user_name"),
        rs.getString("first_name"),
        rs.getString("last_name"),
        (rs.getObject("location") as PGgeometry?)?.geometry as Point?)
}

private fun unmapper() = RowUnmapper<User> { user ->
    val map = mutableMapOf<String, Any>(
            Pair("user_name", user.userName),
            Pair("first_name", user.firstName),
            Pair("last_name", user.lastName))
    if (user.location != null) {
        user.location!!.srid = 4326
        map["location"] = PGgeometry(user.location)
    }
    map;
}