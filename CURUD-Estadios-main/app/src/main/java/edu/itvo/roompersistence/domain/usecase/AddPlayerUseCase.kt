package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.model.Player
import edu.itvo.roompersistence.domain.repository.PlayerRepository
import javax.inject.Inject

class AddPlayerUseCase @Inject constructor(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(
        player: Player
    ) {

        repository.insertPlayer(player)
    }
}