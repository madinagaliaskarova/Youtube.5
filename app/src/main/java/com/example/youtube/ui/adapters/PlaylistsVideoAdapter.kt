package com.example.youtube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube.data.models.Playlist
import com.example.youtube.databinding.ItemPlaylistVideoBinding

class PlaylistsVideoAdapter() :
    RecyclerView.Adapter<PlaylistsVideoAdapter.PlaylistsVideoViewHolder>() {
    private val data = mutableListOf<Playlist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsVideoViewHolder {
        return PlaylistsVideoViewHolder(
            ItemPlaylistVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(list: List<Playlist>) {
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PlaylistsVideoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class PlaylistsVideoViewHolder(private val binding: ItemPlaylistVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(playlist: Playlist) = with(binding) {
            Glide.with(image).load(playlist.snippet.thumbnails.medium.url).into(image)
            txtTitle.text = playlist.snippet.title
            txtVideoDuration.text = playlist.snippet.publishedAt
        }
    }
}