package ru.sindm.otus.model.dto

import ru.sindm.otus.model.dao.User

data class UserInfo(
    val name: String,
    val surname: String,
    val phone: String,
    val birthDate: String?,
    val city: String?
) {

    fun toDao(): User =
        User(
            id = null,
            name = name,
            surname = surname,
            phone = phone,
            birthDate = birthDate,
            city = city
        )
}