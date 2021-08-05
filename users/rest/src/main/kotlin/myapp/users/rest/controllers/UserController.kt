package myapp.users.rest.controllers

import myapp.users.User
import myapp.users.UserModel
import myapp.users.UsersApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import kotlin.streams.toList

@RestController
@RequestMapping("users")
class UserController(
   private val usersApp: UsersApplication
) {
    @GetMapping("/")
    fun users(@RequestParam("ids") ids: String?): List<User> {
        if (ids != null) {
            val parsedIds: List<Int>
            try {
                parsedIds = ids.split(",").stream().map { it.toInt() }.toList()
            } catch (e: Throwable) {
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, "ids must be a list of integers")
            }

            return usersApp.findByIds(parsedIds)
        }
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