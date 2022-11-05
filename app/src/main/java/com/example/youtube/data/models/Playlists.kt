package com.example.youtube.data.models


import com.google.gson.annotations.SerializedName

data class Playlists(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("nextPageToken")
    val nextPageToken: String,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo,
    @SerializedName("items")
    val items: List<Playlist>
)