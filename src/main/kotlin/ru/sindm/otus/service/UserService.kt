package ru.sindm.otus.service

import org.springframework.stereotype.Service
import ru.sindm.otus.model.dto.UserFullInfo
import ru.sindm.otus.model.dto.UserInfo
import ru.sindm.otus.repo.UserRepo

@Service
class UserService(private val userRepo: UserRepo) {

    fun createUser(user: UserInfo): UserFullInfo? {
        userRepo.insertUser(user.toDao())
        return userRepo.selectUserByPhone(user.phone)?.toFullInfo()
    }
}