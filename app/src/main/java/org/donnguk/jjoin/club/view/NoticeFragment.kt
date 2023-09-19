package org.donnguk.jjoin.club.view

import android.view.View
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.BaseFragment
import org.donnguk.jjoin.club.viewmodel.NoticeViewModel
import org.donnguk.jjoin.databinding.FragmentNoticeBinding

class NoticeFragment : BaseFragment<FragmentNoticeBinding, NoticeViewModel>(R.layout.fragment_notice) {
    override val viewModel: NoticeViewModel by lazy {
        NoticeViewModel.NoticeViewModelFactory().create(NoticeViewModel::class.java)
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