package edu.itvo.roompersistence.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import edu.itvo.roompersistence.data.local.dao.PlayerDao
import edu.itvo.roompersistence.data.mapper.toDomain
import edu.itvo.roompersistence.data.mapper.toEntity
import edu.itvo.roompersistence.domain.model.Player
import edu.itvo.roompersistence.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerDao: PlayerDao
) : PlayerRepository {

    override suspend fun insertPlayer(
        player: Player
    ) {

        playerDao.insertPlayer(
            player.toEntity()
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getPlayers(): Flow<List<Player>> {

        return playerDao.getPlayers()
            .map { entities ->

                entities.map { entity ->
                    entity.toDomain()
                }
            }
    }

    override suspend fun deletePlayer(
        player: Player
    ) {

        playerDao.deletePlayer(
            player.toEntity()
        )
    }
}