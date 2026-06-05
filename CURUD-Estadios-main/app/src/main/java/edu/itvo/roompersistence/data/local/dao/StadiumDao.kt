package edu.itvo.roompersistence.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.itvo.roompersistence.data.local.entity.StadiumEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StadiumDao {

    /*
    =========================================
    INSERT STADIUM
    =========================================
     */

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertStadium(
        stadium: StadiumEntity
    )

    /*
    =========================================
    GET STADIUMS
    =========================================
     */

    @Query(
        "SELECT * FROM stadiums ORDER BY name ASC"
    )
    fun getStadiums(): Flow<List<StadiumEntity>>

    /*
    =========================================
    DELETE STADIUM
    =========================================
     */

    @Delete
    suspend fun deleteStadium(
        stadium: StadiumEntity
    )
}
