package com.example.youtube

import android.app.Application
import com.example.youtube.data.repository.Repository

class App : Application() {

    companion object {
        val repository: Repository by lazy {
            Repository()
        }
    }
}