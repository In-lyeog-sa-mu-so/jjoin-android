package org.donnguk.jjoin.club.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.club.model.Notice
import org.donnguk.jjoin.databinding.ItemNoticeBinding

class NoticeAdapter(
    private val onClick: (Int) -> Unit
): ListAdapter<Notice, NoticeAdapter.NoticeViewHolder>(NoticeDiffUtil()) {
    companion object {
        class NoticeDiffUtil: DiffUtil.ItemCallback<Notice>() {
            override fun areItemsTheSame(oldItem: Notice, newItem: Notice): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Notice, newItem: Notice): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(
            ItemNoticeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class NoticeViewHolder(private val binding: ItemNoticeBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(notice: Notice) {
            binding.notice = notice
            binding.executePendingBindings()

            itemView.setOnClickListener{
                onClick(notice.id)
            }
        }
    }
}