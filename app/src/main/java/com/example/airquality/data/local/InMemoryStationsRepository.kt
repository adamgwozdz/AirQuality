package com.example.airquality.data.local

import com.example.airquality.entity.AQStation
import com.example.airquality.logic.repository.LocalStationsRepository

class InMemoryStationsRepository: LocalStationsRepository {

    companion object {
        private var stations: List<AQStation> = emptyList()
    }


    override suspend fun getAll(): List<AQStation> {
        return stations
    }

    override suspend fun save(stations: List<AQStation>) {
        InMemoryStationsRepository.stations = stations
    }
}