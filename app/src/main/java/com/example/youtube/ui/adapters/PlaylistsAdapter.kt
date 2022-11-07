package com.example.youtube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube.data.models.Playlist
import com.example.youtube.databinding.ItemPlaylistBinding

class PlaylistsAdapter(
    private val onClick: (
        id: String,
        title: String,
        description: String,
        videoCount: Int
    ) -> Unit
) :
    RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {
    private val data = mutableListOf<Playlist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlaylistBinding.inflate(
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

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class PlaylistsViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(playlist: Playlist) = with(binding) {
            Glide.with(image).load(playlist.snippet.thumbnails.medium.url).into(image)
            txtTitle.text = playlist.snippet.title
            textviewVideoCount.text = "${playlist.contentDetails.itemCount} video series"
            root.setOnClickListener {
                onClick(
                    data[adapterPosition].id,
                    data[adapterPosition].snippet.title,
                    data[adapterPosition].snippet.description,
                    data[adapterPosition].contentDetails.itemCount
                )
            }
        }
    }
}