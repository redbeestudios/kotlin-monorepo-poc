package myapp.posts.rest.controllers

import myapp.posts.Post
import myapp.posts.PostModel
import myapp.posts.PostsApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("posts")
class PostsController(
    private val postsApplication: PostsApplication
) {
    @GetMapping("/")
    fun allPosts(): List<Post> {
        return postsApplication.findAll()
    }

    @GetMapping("/{id}")
    fun post(@PathVariable("id") id: Int): Post {
        return postsApplication.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Post $id not found")
    }

    @PostMapping("/")
    fun create(@RequestBody post: PostModel): Post {
        return postsApplication.create(post)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        postsApplication.delete(id)
    }
}