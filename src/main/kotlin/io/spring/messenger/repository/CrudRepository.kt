package io.spring.messenger.repository

import org.postgis.PGbox2d
import org.postgis.Point

interface CrudRepository<T, K> {
    fun createTable()
    fun create(m: T): T
    fun findAll(): Iterable<T>
    fun deleteAll(): Int
    fun findByBoundingBox(box: PGbox2d): Iterable<T>
    fun updateLocation(userName:K, location: Point)
}
