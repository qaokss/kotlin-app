package ru.sindm.otus

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import ru.sindm.otus.model.dao.User
import ru.sindm.otus.model.dto.UserFullInfo
import ru.sindm.otus.model.dto.UserInfo
import ru.sindm.otus.repo.UserRepo

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    val port = 0

    private val restTemplates = TestRestTemplate()

    @MockBean
    lateinit var userRepo: UserRepo

    @Test
    fun createUserControllerTest() {
        Mockito.`when`(userRepo.selectUserByPhone("AUTOTEST"))
            .thenReturn(User(100, "TESTAUTO", "TESTAUTO", "TESTAUTO", null, null))
        assertEquals(
            100, restTemplates.postForEntity<UserFullInfo>(
                "http://localhost:${port}/otus/user/create",
                UserInfo("AUTOTEST", "AUTOTEST", "AUTOTEST", null, null)
            ).body?.id
        )
    }
}