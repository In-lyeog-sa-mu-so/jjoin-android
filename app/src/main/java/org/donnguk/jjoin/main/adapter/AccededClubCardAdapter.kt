package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.databinding.ItemAccededClubBinding
import org.donnguk.jjoin.main.model.AccededClubCard

class AccededClubCardAdapter(
    private val detailCallback: (Int) -> Unit,
    private val shareCallback: (Int) -> Unit,
    private val exitCallback: (Int) -> Unit,)
    : ListAdapter<AccededClubCard, AccededClubCardAdapter.ClubCardViewHolder>(AccededClubCardDiffUtil) {
    companion object {
        object AccededClubCardDiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<AccededClubCard>() {
            override fun areItemsTheSame(oldItem: AccededClubCard, newItem: AccededClubCard): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: AccededClubCard, newItem: AccededClubCard): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubCardViewHolder {
        return ClubCardViewHolder(
            ItemAccededClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: ClubCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ClubCardViewHolder(private val binding: ItemAccededClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(accededClubCard: AccededClubCard) {
            binding.accededClubCard = accededClubCard
            binding.executePendingBindings()

            binding.clubDetailButton.setOnClickListener {
                detailCallback(accededClubCard.id)
            }

            binding.clubShareButton.setOnClickListener {
                shareCallback(accededClubCard.id)
            }

            binding.clubExitButton.setOnClickListener {
                exitCallback(accededClubCard.id)
            }
        }
    }
}
