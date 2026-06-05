package edu.itvo.roompersistence.di

import edu.itvo.roompersistence.data.repository.PlayerRepositoryImpl
import edu.itvo.roompersistence.data.repository.StadiumRepositoryImpl
import edu.itvo.roompersistence.domain.repository.PlayerRepository
import edu.itvo.roompersistence.domain.repository.StadiumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPlayerRepository(
        impl: PlayerRepositoryImpl
    ): PlayerRepository

    // ---- nuevo ----
    @Binds
    @Singleton
    abstract fun bindStadiumRepository(
        impl: StadiumRepositoryImpl
    ): StadiumRepository
}
