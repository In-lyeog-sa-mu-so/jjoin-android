package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.databinding.ItemCalenderClubBinding

class CalenderClubAdapter(
    private val clubs: List<String>,
    ) : RecyclerView.Adapter<CalenderClubAdapter.CalenderClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderClubViewHolder {
        return CalenderClubViewHolder(
            ItemCalenderClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = clubs.size

    override fun onBindViewHolder(holder: CalenderClubViewHolder, position: Int) {
        holder.bind(clubs[position])
    }

    inner class CalenderClubViewHolder(private val binding: ItemCalenderClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(clubName: String) {
            binding.clubName = clubName
            binding.executePendingBindings()

            if (clubName.isEmpty()) {
                binding.clubNameTextView.visibility = android.view.View.INVISIBLE
            } else {
                binding.clubNameTextView.visibility = android.view.View.VISIBLE
                binding.clubNameTextView.setBackgroundColor(when(adapterPosition % 3) {
                    0 -> 0x2FE57373.toInt()
                    1 -> 0x2F81C784.toInt()
                    else -> 0x2F64B5F6.toInt()
                }.toInt())
            }
        }
    }
}