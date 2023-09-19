package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.main.model.JoinedClub
import org.donnguk.jjoin.databinding.ItemJoinedClubBinding

class JoinedClubAdapter(private val clickCallback: (Int) -> Unit,)
    : ListAdapter<JoinedClub, JoinedClubAdapter.joinedClubViewHolder>(JoinedClubDiffUtil()) {

    companion object {
        class JoinedClubDiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<JoinedClub>() {
            override fun areItemsTheSame(oldItem: JoinedClub, newItem: JoinedClub): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: JoinedClub, newItem: JoinedClub): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): joinedClubViewHolder {
        return joinedClubViewHolder(
            ItemJoinedClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: joinedClubViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class joinedClubViewHolder(private val binding: ItemJoinedClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(joinedClub: JoinedClub) {
            binding.joinedClub = joinedClub
            binding.executePendingBindings()

            itemView.setOnClickListener {
                clickCallback(joinedClub.id)
            }
        }
    }
}
