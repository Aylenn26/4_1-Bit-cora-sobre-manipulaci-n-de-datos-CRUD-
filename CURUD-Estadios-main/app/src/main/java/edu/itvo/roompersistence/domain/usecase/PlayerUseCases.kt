package edu.itvo.roompersistence.domain.usecase


data class PlayerUseCases(

    val addPlayer: AddPlayerUseCase,
    val getPlayers: GetPlayersUseCase,
    val deletePlayer: DeletePlayerUseCase
)