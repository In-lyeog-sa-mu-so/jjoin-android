package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.R
import org.donnguk.jjoin.databinding.ItemCalenderBinding
import org.donnguk.jjoin.main.model.CalenderDay

class CalenderDayAdapter(
    private val onClickListener: (CalenderDay) -> Unit,
    )
    :ListAdapter<CalenderDay, CalenderDayAdapter.CalenderDayViewHolder>(CalenderDayDiffUtil()){
    companion object {
        class CalenderDayDiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<CalenderDay>() {
            override fun areItemsTheSame(oldItem: CalenderDay, newItem: CalenderDay): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(oldItem: CalenderDay, newItem: CalenderDay): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderDayViewHolder {
        return CalenderDayViewHolder(
            ItemCalenderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CalenderDayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CalenderDayViewHolder(private val binding: ItemCalenderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(calenderDay: CalenderDay) {
            binding.calenderDay = calenderDay
            binding.executePendingBindings()
            binding.clubRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CalenderClubAdapter(clubs = calenderDay.clubs)
                setHasFixedSize(true)
            }

            if (calenderDay.existInMonth) {
                itemView.alpha = 1f
                binding.clubRecyclerView.visibility = View.VISIBLE
            } else {
                itemView.alpha = 0.2f
                binding.clubRecyclerView.visibility = View.INVISIBLE
            }

            if (calenderDay.isSelect) {
                binding.dayTextView.setBackgroundResource(R.drawable.view_oval_gray)
            } else {
                binding.dayTextView.setBackgroundResource(R.drawable.view_oval_white)
            }

            itemView.setOnClickListener {
                onClickListener(calenderDay)
            }
        }
    }
}