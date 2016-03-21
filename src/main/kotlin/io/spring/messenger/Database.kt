package io.spring.messenger

import org.jetbrains.exposed.sql.*
import org.postgis.PGbox2d
import org.postgis.PGgeometry
import org.postgis.Point

object Messages : Table() {
    val id       = integer("id").autoIncrement().primaryKey()
    val content  = text("content")
    val author   = reference("author", Users.userName)
    val location = point("location").nullable()
}

object Users : Table() {
    val userName  = text("user_name").primaryKey()
    val firstName = text("first_name")
    val lastName  = text("last_name")
    val location  = point("location").nullable()
}


fun Table.point(name: String, srid: Int = 4326): Column<Point>
        = registerColumn(name, PointColumnType())

infix fun ExpressionWithColumnType<*>.within(box: PGbox2d) : Op<Boolean>
        = WithinOp(this, box)

private class PointColumnType(val srid: Int = 4326): ColumnType() {
    override fun sqlType() = "GEOMETRY(Point, $srid)"
    override fun valueFromDB(value: Any) = if (value is PGgeometry) value.geometry else value
    override fun notNullValueToDB(value: Any): Any {
         if (value is Point) {
             if (value.srid == Point.UNKNOWN_SRID) value.srid = srid
             return PGgeometry(value)
         }
         return value
     }
}

private class WithinOp(val expr1: Expression<*>, val box: PGbox2d) : Op<Boolean>() {
    override fun toSQL(queryBuilder: QueryBuilder) =
            "${expr1.toSQL(queryBuilder)} && ST_MakeEnvelope(${box.llb.x}, ${box.llb.y}, ${box.urt.x}, ${box.urt.y}, 4326)"
}
