package com.example.airquality.ui.stationlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StationListViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(
        State(stations= listOf())
    )
    init {
        loadStations()
    }

    private fun loadStations(){
        state = State(stations = listOf("Jarek", "Weronika", "Grzegorz"))
    }

    data class State(
        val stations : List<String> = listOf()
    )
}