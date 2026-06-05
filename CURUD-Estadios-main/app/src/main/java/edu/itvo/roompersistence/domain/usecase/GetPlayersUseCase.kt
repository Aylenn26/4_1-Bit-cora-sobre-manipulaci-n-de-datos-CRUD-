package edu.itvo.roompersistence.domain.usecase


import edu.itvo.roompersistence.domain.repository.PlayerRepository
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val repository: PlayerRepository
) {

    operator fun invoke() = repository.getPlayers()
}