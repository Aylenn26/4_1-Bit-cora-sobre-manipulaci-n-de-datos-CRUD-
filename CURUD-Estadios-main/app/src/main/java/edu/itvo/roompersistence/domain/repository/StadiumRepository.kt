package edu.itvo.roompersistence.domain.repository

import edu.itvo.roompersistence.domain.model.Stadium
import kotlinx.coroutines.flow.Flow

interface StadiumRepository {

    suspend fun insertStadium(
        stadium: Stadium
    )

    fun getStadiums(): Flow<List<Stadium>>

    suspend fun deleteStadium(
        stadium: Stadium
    )
}
