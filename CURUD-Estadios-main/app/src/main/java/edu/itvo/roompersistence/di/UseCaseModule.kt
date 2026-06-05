package edu.itvo.roompersistence.di

import edu.itvo.roompersistence.domain.repository.PlayerRepository
import edu.itvo.roompersistence.domain.repository.StadiumRepository
import edu.itvo.roompersistence.domain.usecase.AddPlayerUseCase
import edu.itvo.roompersistence.domain.usecase.AddStadiumUseCase
import edu.itvo.roompersistence.domain.usecase.DeletePlayerUseCase
import edu.itvo.roompersistence.domain.usecase.DeleteStadiumUseCase
import edu.itvo.roompersistence.domain.usecase.GetPlayersUseCase
import edu.itvo.roompersistence.domain.usecase.GetStadiumsUseCase
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases
import edu.itvo.roompersistence.domain.usecase.StadiumUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providePlayerUseCases(
        repository: PlayerRepository
    ): PlayerUseCases {

        return PlayerUseCases(
            addPlayer = AddPlayerUseCase(repository),
            getPlayers = GetPlayersUseCase(repository),
            deletePlayer = DeletePlayerUseCase(repository)
        )
    }

    // ---- nuevo ----
    @Provides
    fun provideStadiumUseCases(
        repository: StadiumRepository
    ): StadiumUseCases {

        return StadiumUseCases(
            addStadium = AddStadiumUseCase(repository),
            getStadiums = GetStadiumsUseCase(repository),
            deleteStadium = DeleteStadiumUseCase(repository)
        )
    }
}
