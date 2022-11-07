package com.example.youtube.ui.activities.playlists.details

import android.content.Intent
import android.view.LayoutInflater
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube.base.BaseActivity
import com.example.youtube.core.common.InternetConnectivityManager
import com.example.youtube.databinding.ActivityDetailedPlaylistBinding
import com.example.youtube.ui.activities.playlists.PlaylistsActivity
import com.example.youtube.ui.adapters.PlaylistsVideoAdapter

class DetailedPlaylistActivity :
    BaseActivity<DetailedPlaylistViewModel, ActivityDetailedPlaylistBinding>() {
    private val playlistsVideoAdapter = PlaylistsVideoAdapter()
    private val internetConnectivityManager: InternetConnectivityManager by lazy {
        InternetConnectivityManager(this)
    }

    override val viewModel: DetailedPlaylistViewModel by lazy {
        ViewModelProvider(this)[DetailedPlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailedPlaylistBinding {
        return ActivityDetailedPlaylistBinding.inflate(inflater)
    }

    override fun initView() = with(binding) {

        rvPlaylistDetails.adapter = playlistsVideoAdapter
        rvPlaylistDetails.layoutManager = LinearLayoutManager(this@DetailedPlaylistActivity)
        tvTitle.text = intent.getStringExtra("playlistTitle")
        tvDescription.text = intent.getStringExtra("playlistDescription")
        tvVideoCount.text = "${intent.getIntExtra("playlistVideoCount", 0)} video series"

        internetConnectivityManager.observe(this@DetailedPlaylistActivity) {
            iNoInternet.root.isVisible = !it
            rvPlaylistDetails.isGone = !it
        }
        viewModel.getPlaylist(intent.getStringExtra("playlistId").toString())
            .observe(this@DetailedPlaylistActivity) {
                playlistsVideoAdapter.setData(it.items)
            }
    }

    override fun initListener() {
        binding.tvBack.setOnClickListener {
            Intent(this, PlaylistsActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}