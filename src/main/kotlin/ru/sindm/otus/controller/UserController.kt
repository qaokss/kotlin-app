package ru.sindm.otus.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sindm.otus.model.dto.UserFullInfo
import ru.sindm.otus.model.dto.UserInfo
import ru.sindm.otus.service.UserService

@RestController
@RequestMapping("/otus/user")
class UserController(private val userService: UserService) {

    @PostMapping("/create")
    fun createUser(@RequestBody user: UserInfo): UserFullInfo? =
        userService.createUser(user)
}