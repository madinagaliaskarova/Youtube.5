package com.example.youtube.ui.activities.playlists

import android.content.Intent
import android.view.LayoutInflater
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube.base.BaseActivity
import com.example.youtube.databinding.ActivityPlaylistsBinding
import com.example.youtube.ui.activities.playlists.details.DetailedPlaylistActivity
import com.example.youtube.ui.adapters.PlaylistsAdapter
import com.example.youtube.utils.InternetConnectivityManager

class PlaylistsActivity : BaseActivity<PlaylistsViewModel, ActivityPlaylistsBinding>() {
    private val playlistsAdapter = PlaylistsAdapter(this::onItemClick)
    private val internetConnectivityManager: InternetConnectivityManager by lazy {
        InternetConnectivityManager(this)
    }

    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(inflater)
    }

    override fun initView() = with(binding) {
        recyclerview.adapter = playlistsAdapter
        recyclerview.layoutManager = LinearLayoutManager(this@PlaylistsActivity)
        internetConnectivityManager.observe(this@PlaylistsActivity) {
            iNoInternet.root.isVisible = !it
            recyclerview.isGone = !it
        }
    }

    override fun initViewModel() {
        viewModel.playlists().observe(this) {
            playlistsAdapter.setData(it)
        }
    }

    private fun onItemClick(id: String) {
        Intent(this, DetailedPlaylistActivity::class.java).apply {
            putExtra("playlistId", id)
            startActivity(this)
        }
    }
}