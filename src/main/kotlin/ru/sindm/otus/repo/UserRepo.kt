package ru.sindm.otus.repo

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import ru.sindm.otus.model.dao.User
import java.sql.ResultSet

@Component
class UserRepo(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {

    fun selectUserByPhone(phone: String): User? {
        return namedParameterJdbcTemplate.queryForObject(
            sqlSelectUserByPhone,
            mapOf("phone" to phone),
            UserDaoRowMapper()
        )
    }

    fun insertUser(user: User) =
        namedParameterJdbcTemplate.update(
            sqlCreateUser,
            mapOf(
                "name" to user.name,
                "surname" to user.surname,
                "phone" to user.phone,
                "birthDate" to user.birthDate,
                "city" to user.city
            )
        )

    private val sqlCreateUser =
        """
            INSERT INTO "public".user (name, surname, phone, birth_date, city)
             VALUES(:name, :surname, :phone, :birthDate, :city)
        """.trimIndent()

    private val sqlSelectUserByPhone =
        """
            SELECT * FROM "public".user WHERE phone = :phone
        """.trimIndent()

    private class UserDaoRowMapper : RowMapper<User> {
        override fun mapRow(rs: ResultSet, rowNum: Int): User =
            User(
                id = rs.getLong("id"),
                name = rs.getString("name"),
                surname = rs.getString("surname"),
                phone = rs.getString("phone"),
                birthDate = rs.getString("birth_date"),
                city = rs.getString("city")
            )
    }



}