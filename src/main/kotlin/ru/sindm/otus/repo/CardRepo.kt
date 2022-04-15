package ru.sindm.otus.repo

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import ru.sindm.otus.model.dao.Card

@Component
class CardRepo(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {

    fun insertCard(card: Card): Long? =
        namedParameterJdbcTemplate.queryForObject(
            sqlInsertCard,
            mapOf(
                "providerId" to card.providerId,
                "cardNumber" to card.cardNumber,
                "userId" to card.userId,
                "balance" to card.balance
            ),
            Long::class.java
        )

    private val sqlInsertCard =
        """
            INSERT INTO "public".card (provider_id, card_number, user_id, balance)
            VALUES (:providerId, :cardNumber, :userId, :balance)
            RETURNING id;
        """.trimIndent()
}