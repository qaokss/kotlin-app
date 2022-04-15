package ru.sindm.otus.repo

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class ProviderRepo(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {

    fun selectProviderIdByName(name: String): Long? =
        namedParameterJdbcTemplate.queryForObject(
            sqlSelectProviderId,
            mapOf("name" to name),
            Long::class.java
        )

    private val sqlSelectProviderId =
        """
            SELECT id FROM "public".provider WHERE name = :name
        """.trimIndent()
}