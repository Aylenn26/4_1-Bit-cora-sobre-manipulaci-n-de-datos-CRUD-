package edu.itvo.roompersistence.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.itvo.roompersistence.data.local.dao.PlayerDao
import edu.itvo.roompersistence.data.local.dao.StadiumDao
import edu.itvo.roompersistence.data.local.entity.PlayerEntity
import edu.itvo.roompersistence.data.local.entity.StadiumEntity


@Database(
    entities = [
        PlayerEntity::class,
        StadiumEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    abstract fun stadiumDao(): StadiumDao     // <-- nuevo DAO
}
