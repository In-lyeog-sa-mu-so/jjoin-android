package org.donnguk.jjoin.club.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.donnguk.jjoin.club.model.Plan
import org.donnguk.jjoin.databinding.ItemPlanBinding

class PlanAdapter(
    private val onClickListener: (Int) -> Unit,
): ListAdapter<Plan, PlanAdapter.PlanViewHolder>(PlanDiffUtil()) {
    companion object {
        class PlanDiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<Plan>() {
            override fun areItemsTheSame(oldItem: Plan, newItem: Plan): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Plan, newItem: Plan): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        return PlanViewHolder(
            ItemPlanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PlanViewHolder(private val binding: ItemPlanBinding)
        :RecyclerView.ViewHolder(binding.root) {

        fun bind(plan: Plan) {
            binding.plan = plan
            binding.executePendingBindings()

            itemView.setOnClickListener {
                onClickListener(plan.id)
            }

            if (plan.isAgree != null) {
                if (plan.isAgree) {
                    binding.agreeTextView.setTextColor(0xFF00FF00.toInt())
                } else {
                    binding.disAgreeTextView.setTextColor(0xFFFF0000.toInt())
                }
            }
        }
    }
}