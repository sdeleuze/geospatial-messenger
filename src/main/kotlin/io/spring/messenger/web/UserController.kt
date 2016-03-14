package io.spring.messenger.web

import io.spring.messenger.domain.User
import io.spring.messenger.repository.UserRepository
import org.postgis.PGbox2d
import org.postgis.Point
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/user")
class UserController @Autowired constructor(val repository: UserRepository) {

    @GetMapping
    fun findUsers() = repository.findAll()

    @PostMapping
    fun createUser(@RequestBody user: User) = repository.create(user)

    @PutMapping("/{userName}/location") @ResponseStatus(NO_CONTENT)
    fun updateLocation(@PathVariable userName:String, @RequestBody location: Point)
            = repository.updateLocation(userName, location)

    /**
     * {@code box} parameter should use this format: xmin%20ymin,xmax%20ymax
     */
    @GetMapping("/bbox/{box}")
    fun findByBoundingBox(@PathVariable userName:String, @PathVariable box:String)
            = repository.findByBoundingBox(PGbox2d("BOX($box)"))

}