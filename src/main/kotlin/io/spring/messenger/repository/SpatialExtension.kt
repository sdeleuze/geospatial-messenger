package io.spring.messenger.repository

import org.jetbrains.exposed.sql.*
import org.postgis.PGbox2d
import org.postgis.PGgeometry
import org.postgis.Point

fun Table.point(name: String, srid: Int = 4326): Column<Point> = registerColumn(name, PointColumnType())

class PointColumnType(val srid: Int = 4326): ColumnType() {

    override fun sqlType(): String  = "GEOMETRY(Point, $srid)"

    override fun valueFromDB(value: Any): Any {
        if (value is PGgeometry) {
            return value.geometry
        }
        return value
    }

     override fun notNullValueToDB(value: Any): Any {
         if (value is Point) {
             if (value.srid == Point.UNKNOWN_SRID) value.srid = srid
             return PGgeometry(value)
         }
         return value
     }
}

infix fun ExpressionWithColumnType<*>.within(box: PGbox2d) : Op<Boolean> {
    return WithinOp(this, box)
}

class WithinOp(val expr1: Expression<*>, val box: PGbox2d) : Op<Boolean>() {

    override fun toSQL(queryBuilder: QueryBuilder) = """${expr1.toSQL(queryBuilder)}
    && ST_MakeEnvelope(${box.llb.x}, ${box.llb.y}, ${box.urt.x}, ${box.urt.y}, 4326)"""
}

