package ru.sindm.otus.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserFullInfo(
    @JsonProperty("id")
    val id: Long?,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("surname")
    val surname: String,
    @JsonProperty("phone")
    val phone: String,
    @JsonProperty("birthDate")
    val birthDate: String?,
    @JsonProperty("city")
    val city: String?
)