package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.repository.PlayerRepository
import edu.itvo.roompersistence.domain.model.Player

class DeletePlayerUseCase(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(
        player: Player
    ) {

        repository.deletePlayer(
            player
        )
    }
}