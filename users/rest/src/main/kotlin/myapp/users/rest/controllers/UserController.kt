package myapp.users.rest.controllers

import myapp.users.User
import myapp.users.UserModel
import myapp.users.UsersApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class UserController @Autowired constructor(
   private val usersApp: UsersApplication
) {
    @GetMapping("/")
    fun users(): List<User> {
        return usersApp.findAll()
    }

    @GetMapping("/{id}")
    fun userById(@PathVariable("id") id: Int): User {
        return usersApp.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: UserModel): User {
        return usersApp.create(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Int) {
        usersApp.delete(id)
    }
}