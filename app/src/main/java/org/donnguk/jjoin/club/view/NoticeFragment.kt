package org.donnguk.jjoin.club.view

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseFragment
import org.donnguk.jjoin.club.adapter.NoticeAdapter
import org.donnguk.jjoin.club.viewmodel.NoticeViewModel
import org.donnguk.jjoin.databinding.FragmentNoticeBinding

class NoticeFragment : BaseFragment<FragmentNoticeBinding, NoticeViewModel>(R.layout.fragment_notice) {
    override val viewModel: NoticeViewModel by lazy {
        NoticeViewModel.NoticeViewModelFactory().create(NoticeViewModel::class.java)
    }

    override fun initView() {
        super.initView()

        binding.noticeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NoticeAdapter(
                onClick = { id ->
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
        viewModel.notices.observe(viewLifecycleOwner) {
            (binding.noticeRecyclerView.adapter as NoticeAdapter).submitList(it)
        }
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }
}