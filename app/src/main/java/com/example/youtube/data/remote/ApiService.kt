package com.example.youtube.data.remote

import com.example.youtube.data.models.Playlist
import com.example.youtube.data.models.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("key") apiKey: String,
    ): Call<Playlists>

    @GET("playlistItems")
    fun getPlaylistItem(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("playlistId") playlistId: String,
    ): Call<Playlists>
}
/*
@GET() -Ю запрос на получение данных. С GET только получить, ничего не отправляя на сервер, кроме @Query.
@POST() -> запрос на отправку данных на сервер. То есть при отправке данных они там появятся.
@PUT() -> изменить данные на сервере.
@PATCH() -> тоже изменяет

OkHTTP коды
200 -> запрос удался, все четко
201 -> запрос удался, но данных нету
400 -> Bad Request, запрос не удался
500 -> Internal server error
 */