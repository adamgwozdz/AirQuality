package com.example.airquality.data

import com.example.airquality.data.airly.AirlyMapper
import com.example.airquality.data.airly.AirlyService
import com.example.airquality.entity.AQStation
import com.example.airquality.logic.repository.RemoteStationsRepository
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import javax.inject.Inject

class AirlyStationDataSource @Inject constructor(private val airlyService: AirlyService) : RemoteStationsRepository {
    override suspend fun getAll(): List<AQStation> {
        val installations = airlyService.getInstallations()
        return installations.map { AirlyMapper().mapInstallation(it) }
    }
}