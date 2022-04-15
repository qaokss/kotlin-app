package ru.sindm.otus.model.dto

import ru.sindm.otus.model.dao.Card

data class CardInfo(
    val providerName: String,
    val cardNumber: String,
    val userPhone: String,
    val balance: Long?
) {
    fun toDao(providerId: Long, userId: Long): Card =
        Card(
            id = null,
            providerId = providerId,
            cardNumber = cardNumber,
            userId = userId,
            balance = balance
        )
}