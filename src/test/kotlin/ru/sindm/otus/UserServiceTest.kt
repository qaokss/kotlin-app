package ru.sindm.otus

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import ru.sindm.otus.model.dao.User
import ru.sindm.otus.model.dto.UserInfo
import ru.sindm.otus.repo.UserRepo
import ru.sindm.otus.service.UserService

@ExtendWith(SpringExtension::class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    lateinit var userService: UserService

    @MockBean
    lateinit var userRepo: UserRepo

    @Test
    fun createUserTest() {
        val user = UserInfo("AUTOTEST", "AUTOTEST", "AUTOTEST", null, null)
        Mockito.`when`(userRepo.selectUserByPhone(user.phone))
            .thenReturn(User(100, "TESTAUTO", "TESTAUTO", "TESTAUTO", null, null))
        assertEquals(100, userService.createUser(user)?.id)
    }
}