package com.example.airquality.logic.repository

import com.example.airquality.entity.AQStation

interface RemoteStationsRepository {
    suspend fun getAll(): List<AQStation>
}