package org.donnguk.jjoin.main.view

import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseFragment
import org.donnguk.jjoin.databinding.FragmentCalenderBinding
import org.donnguk.jjoin.main.adapter.CalenderDayAdapter
import org.donnguk.jjoin.main.viewmodel.CalenderViewModel

class CalenderFragment : BaseFragment<FragmentCalenderBinding, CalenderViewModel>(R.layout.fragment_calender) {
    override val viewModel: CalenderViewModel by lazy {
        CalenderViewModel.CalenderViewModelFactory().create(CalenderViewModel::class.java)
    }

    override fun initView() {
        super.initView()
        binding.calendarRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 7)
            adapter = CalenderDayAdapter (
                onClickListener = { calenderDay ->
                    Toast.makeText(context, calenderDay.date.toString(), Toast.LENGTH_SHORT).show()
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
        viewModel.calenderDays.observe(viewLifecycleOwner) {
            (binding.calendarRecyclerView.adapter as CalenderDayAdapter).submitList(it)
        }
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }
}