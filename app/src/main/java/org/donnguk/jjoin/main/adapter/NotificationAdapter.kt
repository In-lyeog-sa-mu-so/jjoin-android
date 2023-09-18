package org.donnguk.jjoin.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.databinding.ItemNotificationBinding
import org.donnguk.jjoin.main.model.Notification

class NotificationAdapter(
    private val clickCallback: (Int) -> Unit, )
    : ListAdapter<Notification, NotificationAdapter.NotificationViewHolder>(NotificationDiffUtil()){

    companion object {
        class NotificationDiffUtil : DiffUtil.ItemCallback<Notification>() {
            override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    inner class NotificationViewHolder(val binding: ItemNotificationBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(notification: Notification) {
            binding.notification = notification
            binding.executePendingBindings()

            itemView.setOnClickListener {
                clickCallback(notification.id)
            }
        }
    }
}