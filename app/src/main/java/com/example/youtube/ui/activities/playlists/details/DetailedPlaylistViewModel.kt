package com.example.youtube.ui.activities.playlists.details

import com.example.youtube.App.Companion.repository
import com.example.youtube.base.BaseViewModel

class DetailedPlaylistViewModel : BaseViewModel() {
    fun getPlaylist(id: String) = repository.playlist(id)
}