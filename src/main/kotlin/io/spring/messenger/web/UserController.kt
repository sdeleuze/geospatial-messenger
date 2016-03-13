package io.spring.messenger.web

import io.spring.messenger.domain.User
import io.spring.messenger.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val repository: UserRepository) {

    @GetMapping
    fun findUsers() = repository.findAll()

    @PostMapping
    fun createUser(@RequestBody user: User) = repository.create(user)

}