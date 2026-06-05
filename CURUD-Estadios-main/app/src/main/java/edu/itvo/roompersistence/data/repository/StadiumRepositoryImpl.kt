package edu.itvo.roompersistence.data.repository

import edu.itvo.roompersistence.data.local.dao.StadiumDao
import edu.itvo.roompersistence.data.mapper.toDomain
import edu.itvo.roompersistence.data.mapper.toEntity
import edu.itvo.roompersistence.domain.model.Stadium
import edu.itvo.roompersistence.domain.repository.StadiumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StadiumRepositoryImpl @Inject constructor(
    private val stadiumDao: StadiumDao
) : StadiumRepository {

    override suspend fun insertStadium(
        stadium: Stadium
    ) {

        stadiumDao.insertStadium(
            stadium.toEntity()
        )
    }

    override fun getStadiums(): Flow<List<Stadium>> {

        return stadiumDao.getStadiums()
            .map { entities ->

                entities.map { entity ->
                    entity.toDomain()
                }
            }
    }

    override suspend fun deleteStadium(
        stadium: Stadium
    ) {

        stadiumDao.deleteStadium(
            stadium.toEntity()
        )
    }
}
