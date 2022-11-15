package com.example.airquality.logic

import com.example.airquality.entity.AQStation
import javax.inject.Inject

class GetStationsUseCase @Inject constructor(
    private val remoteStationsRepository: RemoteStationsRepository
) {

    suspend fun execute(): List<AQStation> {
        return remoteStationsRepository.getAll()
    }
}