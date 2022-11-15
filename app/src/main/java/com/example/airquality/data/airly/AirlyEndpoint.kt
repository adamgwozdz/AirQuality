package com.example.airquality.data.airly

class AirlyEndpoint {
    companion object {
        const val HOST = "https://airapi.airly.eu/v2/"
        const val INSTALLATIONS = "installations/nearest?lat=50.2649&lng=19.0238&maxDistanceKM=5&maxResults=100"
    }
}