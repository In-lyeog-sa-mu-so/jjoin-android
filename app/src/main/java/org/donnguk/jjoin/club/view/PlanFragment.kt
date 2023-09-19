package org.donnguk.jjoin.club.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.BaseFragment
import org.donnguk.jjoin.club.viewmodel.PlanViewModel
import org.donnguk.jjoin.databinding.FragmentPlanBinding

class PlanFragment : BaseFragment<FragmentPlanBinding, PlanViewModel>(R.layout.fragment_plan) {
    override val viewModel: PlanViewModel by lazy {
        PlanViewModel.PlanViewModelFactory().create(PlanViewModel::class.java)
    }

    override fun initView() {
        super.initView()
    }

    override fun initViewModel() {
        super.initViewModel()
    }

    override fun initListener(view: View) {
        super.initListener(view)
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }
}