package ru.sindm.otus.model.dao

import ru.sindm.otus.model.dto.UserFullInfo

data class User(
    val id: Long?,
    val name: String,
    val surname: String,
    val phone: String,
    val birthDate: String?,
    val city: String?
) {

    fun toFullInfo(): UserFullInfo =
        UserFullInfo(
            id = id,
            name = name,
            surname = surname,
            phone = phone,
            birthDate = birthDate,
            city = city
        )
}