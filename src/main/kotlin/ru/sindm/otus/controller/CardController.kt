package ru.sindm.otus.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sindm.otus.model.dto.CardInfo
import ru.sindm.otus.service.CardService

@RestController
@RequestMapping("/otus/card")
class CardController(
    private val cardService: CardService
) {

    @PostMapping("/create")
    fun createCard(@RequestBody card: CardInfo): Long? =
        cardService.createCard(card)
}