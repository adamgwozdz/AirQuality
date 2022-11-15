package com.example.airquality.logic.usecase

import com.example.airquality.entity.AQStation
import com.example.airquality.logic.repository.RemoteStationsRepository
import javax.inject.Singleton

@Singleton
class FakeRemoteStationsRepository: RemoteStationsRepository {
    override suspend fun getAll(): List<AQStation> {
        return emptyList()
    }
}