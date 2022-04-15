package ru.sindm.otus.model.dao

data class Card(
    val id: Long?,
    val providerId: Long,
    val cardNumber: String,
    val userId: Long,
    val balance: Long?
)