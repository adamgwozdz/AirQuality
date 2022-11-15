package com.example.airquality.data.local.db

import androidx.room.*
import com.example.airquality.entity.AQStation
import com.example.airquality.logic.repository.LocalStationsRepository
import javax.inject.Inject

class DatabaseStationsRepository @Inject constructor(private val database: AppDatabase) :
    LocalStationsRepository {
    override suspend fun getAll(): List<AQStation> {
        val stationEntities = database.stationsDao().getAll()
        return stationEntities.map { AQStation(it.uid, it.name, it.city, it.sponsor, it.sponsorImage) }
    }

    override suspend fun save(stations: List<AQStation>) {
        database.stationsDao().insert(stations.map { StationEntity(it.id, it.name, it.city, it.sponsor, it.sponsorImage) })
    }
}


@Entity
data class StationEntity(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "sponsor") val sponsor: String,
    @ColumnInfo(name = "sponsor_image") val sponsorImage: String?
)

@Dao
interface StationsDao {
    @Query("select * from stationentity")
    suspend fun getAll(): List<StationEntity>

    @Insert
    suspend fun insert(stations: List<StationEntity>)
}

@Database(entities = [StationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stationsDao(): StationsDao
}