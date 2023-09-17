package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.databinding.ItemClubBinding
import org.donnguk.jjoin.main.model.ClubCard

class ClubCardAdapter(
    private val detailCallback: (Int) -> Unit,
    private val shareCallback: (Int) -> Unit,
    private val exitCallback: (Int) -> Unit,)
    : ListAdapter<ClubCard, ClubCardAdapter.ClubCardViewHolder>(ClubCardDiffUtil) {
    companion object {
        object ClubCardDiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ClubCard>() {
            override fun areItemsTheSame(oldItem: ClubCard, newItem: ClubCard): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ClubCard, newItem: ClubCard): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubCardViewHolder {
        return ClubCardViewHolder(
            ItemClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: ClubCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ClubCardViewHolder(private val binding: ItemClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(clubCard: ClubCard) {
            binding.clubCard = clubCard
            binding.executePendingBindings()

            binding.clubDetailButton.setOnClickListener {
                detailCallback(clubCard.id)
            }

            binding.clubShareButton.setOnClickListener {
                shareCallback(clubCard.id)
            }

            binding.clubExitButton.setOnClickListener {
                exitCallback(clubCard.id)
            }
        }
    }
}
