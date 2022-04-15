package ru.sindm.otus.service

import org.springframework.stereotype.Service
import ru.sindm.otus.model.dto.CardInfo
import ru.sindm.otus.repo.CardRepo
import ru.sindm.otus.repo.ProviderRepo
import ru.sindm.otus.repo.UserRepo

@Service
class CardService(
    private val cardRepo: CardRepo,
    private val userRepo: UserRepo,
    private val providerRepo: ProviderRepo
) {

    fun createCard(card: CardInfo): Long? {
        val providerId = providerRepo.selectProviderIdByName(card.providerName)
        val userId = userRepo.selectUserByPhone(card.userPhone)!!.id!!
        return cardRepo.insertCard(card.toDao(providerId!!, userId))
    }
}