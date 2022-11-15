package com.example.airquality.ui.stationlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun StationListScreen() {
    val viewModel: StationListViewModel = hiltViewModel()
    val state = viewModel.state

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
        onRefresh = { viewModel.onPullToRefresh() }) {
        LazyColumn() {
            items(state.stations) {
                Text(text = it)
            }
        }
    }

}