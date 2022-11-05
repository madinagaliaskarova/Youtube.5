package com.example.youtube.ui.activities.playlists.details

import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.base.BaseActivity
import com.example.youtube.databinding.ActivityDetailedPlaylistBinding
import com.example.youtube.utils.InternetConnectivityManager

class DetailedPlaylistActivity :
    BaseActivity<DetailedPlaylistViewModel, ActivityDetailedPlaylistBinding>() {
    private val internetConnectivityManager: InternetConnectivityManager by lazy {
        InternetConnectivityManager(this)
    }

    override val viewModel: DetailedPlaylistViewModel by lazy {
        ViewModelProvider(this)[DetailedPlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailedPlaylistBinding {
        return ActivityDetailedPlaylistBinding.inflate(inflater)
    }

    override fun initView() {
        Toast.makeText(this, intent.getStringExtra("playlistId"), Toast.LENGTH_LONG).show()
        internetConnectivityManager.observe(this) {
            binding.iNoInternet.root.isVisible = !it
        }
    }
}