package com.example.youtube.ui.activities.playlists

import com.example.youtube.App.Companion.repository
import com.example.youtube.base.BaseViewModel


class PlaylistsViewModel : BaseViewModel() {

    fun getPlaylists() = repository.playlists()
}