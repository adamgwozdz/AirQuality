package com.example.airquality.logic

import com.example.airquality.entity.AQStation

interface RemoteStationsRepository {
    suspend fun getAll(): List<AQStation>
}