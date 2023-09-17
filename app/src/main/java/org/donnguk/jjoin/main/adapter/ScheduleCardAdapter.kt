package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.databinding.ItemScheduleBinding
import org.donnguk.jjoin.main.model.ScheduleCard

class ScheduleCardAdapter(
    private val agreeCallback: (Int) -> Unit,
    private val disAgreeCallback: (Int) -> Unit,)
    : ListAdapter<ScheduleCard, ScheduleCardAdapter.ScheduleCardViewHolder>(ScheduleDiffUtil){
    companion object {
        object ScheduleDiffUtil : DiffUtil.ItemCallback<ScheduleCard>() {
            override fun areItemsTheSame(oldItem: ScheduleCard, newItem: ScheduleCard): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ScheduleCard, newItem: ScheduleCard): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleCardViewHolder {
        return ScheduleCardViewHolder(
            ItemScheduleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: ScheduleCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ScheduleCardViewHolder(val binding: ItemScheduleBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(scheduleCard: ScheduleCard) {
            binding.schedule = scheduleCard
            binding.executePendingBindings()

            binding.agreeButton.setOnClickListener {
                agreeCallback(scheduleCard.id)
            }

            binding.disAgreeButton.setOnClickListener {
                disAgreeCallback(scheduleCard.id)
            }
        }
    }
}