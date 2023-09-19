package org.donnguk.jjoin.club.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.club.model.Album
import org.donnguk.jjoin.databinding.ItemAlbumBinding

class AlbumAdapter(
    private val onClickListener: (Int) -> Unit,
    )
    : ListAdapter<Album, AlbumAdapter.AlbumViewHolder>(AlbumPictureDiffUtil()){
    companion object {
        class AlbumPictureDiffUtil: DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class AlbumViewHolder(private val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.album = album
            binding.executePendingBindings()

            itemView.setOnClickListener{
                onClickListener(album.id)
            }
        }
    }
}