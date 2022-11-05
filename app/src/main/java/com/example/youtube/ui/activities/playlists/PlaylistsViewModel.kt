package com.example.youtube.ui.activities.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.BuildConfig.API_KEY
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.models.Playlist
import com.example.youtube.data.models.Playlists
import com.example.youtube.data.remote.ApiService
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlaylistsViewModel : BaseViewModel() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create();
    }

    fun playlists(): LiveData<List<Playlist>> {
        return getPlayLists()
    }

    private fun getPlayLists(): LiveData<List<Playlist>> {
        val data = MutableLiveData<List<Playlist>>()

        apiService.getPlaylists(Constant.channelId, Constant.part, API_KEY)
            .enqueue(object : Callback<Playlists> {
                override fun onResponse(
                    call: Call<Playlists>,
                    response: Response<Playlists>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()?.items
                    }
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {
                }
            })
        return data
    }
}