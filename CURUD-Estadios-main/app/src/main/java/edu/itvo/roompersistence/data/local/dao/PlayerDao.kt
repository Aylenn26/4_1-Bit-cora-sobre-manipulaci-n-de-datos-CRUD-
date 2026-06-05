package edu.itvo.roompersistence.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.itvo.roompersistence.data.local.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    /*
    =========================================
    INSERT PLAYER
    =========================================
     */

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertPlayer(
        player: PlayerEntity
    )

    /*
    =========================================
    GET PLAYERS
    =========================================
     */

    @Query(
        "SELECT * FROM players ORDER BY fullName ASC"
    )
    fun getPlayers(): Flow<List<PlayerEntity>>

    /*
    =========================================
    DELETE PLAYER
    =========================================
     */

    @Delete
    suspend fun deletePlayer(
        player: PlayerEntity
    )
}