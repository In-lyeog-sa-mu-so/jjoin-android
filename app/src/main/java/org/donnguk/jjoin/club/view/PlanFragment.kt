package org.donnguk.jjoin.club.view

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseFragment
import org.donnguk.jjoin.club.adapter.PlanAdapter
import org.donnguk.jjoin.club.viewmodel.PlanViewModel
import org.donnguk.jjoin.databinding.FragmentPlanBinding

class PlanFragment : BaseFragment<FragmentPlanBinding, PlanViewModel>(R.layout.fragment_plan) {
    override val viewModel: PlanViewModel by lazy {
        PlanViewModel.PlanViewModelFactory().create(PlanViewModel::class.java)
    }

    override fun initView() {
        super.initView()
        binding.planRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PlanAdapter(
                onClickListener = {id ->
                    Toast.makeText(context, "id: $id", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel
    }

    override fun initListener(view: View) {
        super.initListener(view)
        viewModel.plans.observe(viewLifecycleOwner) {
            (binding.planRecyclerView.adapter as PlanAdapter).submitList(it)
        }
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }
}