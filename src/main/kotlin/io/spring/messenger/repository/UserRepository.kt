package io.spring.messenger.repository

import com.nurkiewicz.jdbcrepository.JdbcRepository
import com.nurkiewicz.jdbcrepository.RowUnmapper
import io.spring.messenger.domain.User
import org.postgis.PGbox2d
import org.postgis.PGgeometry
import org.postgis.Point
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
open class UserRepository : JdbcRepository<User, String>(UserRowMaper(), UserRowUnmapper(), "\"users\"", "user_name") {

    open fun updateLocation(userName:String, location: Point): Unit {
        location.srid = 4326
        jdbcOperations.update("UPDATE ${table.name} SET location = '${PGgeometry(location)}' WHERE user_name = '$userName'")
    }

    open fun findByBoundingBox(box: PGbox2d): List<User>
        = jdbcOperations.query("""SELECT * FROM ${table.name}
                                  WHERE location &&
                                  ST_MakeEnvelope(${box.llb.x}, ${box.llb.y}, ${box.urt.x}, ${box.urt.y}
                                  , 4326)""", rowMapper)

    class UserRowMaper : RowMapper<User> {
        override fun mapRow(rs: ResultSet, rowNum: Int)
                = User(
                    rs.getString("user_name"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    (rs.getObject("location") as PGgeometry?)?.geometry as Point?)
    }

    class UserRowUnmapper() : RowUnmapper<User> {
        override fun mapColumns(user: User): Map<String, Any>  {
            val map = mutableMapOf<String, Any>(
                    Pair("user_name", user.userName),
                    Pair("first_name", user.firstName),
                    Pair("last_name", user.lastName))
            if (user.location != null) {
                user.location!!.srid = 4326
                map["location"] = PGgeometry(user.location)
            }
            return map;
        }
    }



}
