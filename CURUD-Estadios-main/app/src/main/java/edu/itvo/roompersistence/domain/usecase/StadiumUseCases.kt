package edu.itvo.roompersistence.domain.usecase

data class StadiumUseCases(
    val addStadium: AddStadiumUseCase,
    val getStadiums: GetStadiumsUseCase,
    val deleteStadium: DeleteStadiumUseCase
)
