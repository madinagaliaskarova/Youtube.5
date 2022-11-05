package com.example.youtube.data.models


import com.google.gson.annotations.SerializedName

data class ContentDetails(
    @SerializedName("itemCount")
    val itemCount: Int
)