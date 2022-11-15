package com.example.airquality.logic.usecase

import com.example.airquality.entity.AQStation
import com.example.airquality.logic.repository.LocalStationsRepository
import com.example.airquality.logic.repository.RemoteStationsRepository
import javax.inject.Inject

class GetStationsUseCase @Inject constructor(
    private val remoteStationsRepository: RemoteStationsRepository,
    private val localStationsRepository: LocalStationsRepository
) {

    suspend fun execute(): List<AQStation> {
        val localStations = localStationsRepository.getAll()
        if (localStations.isEmpty()) {
            val remoteStations = remoteStationsRepository.getAll()
            localStationsRepository.save(remoteStations)
            return remoteStations
        }
        return localStations
    }
}