package org.donnguk.jjoin.club.view

import com.google.android.material.tabs.TabLayoutMediator
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseActivity
import org.donnguk.jjoin.club.adapter.PagerAdapter
import org.donnguk.jjoin.club.viewmodel.ClubDetailViewModel
import org.donnguk.jjoin.databinding.ActivityClubDetailBinding

class ClubDetailActivity : BaseActivity<ActivityClubDetailBinding, ClubDetailViewModel>(R.layout.activity_club_detail) {
    override val viewModel: ClubDetailViewModel by lazy {
        ClubDetailViewModel.ClubDetailViewModelFactory().create(ClubDetailViewModel::class.java)
    }

    override fun initView() {
        super.initView()

        binding.viewFragmentPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewFragmentPager) { tab, position ->
            when (position) {
                0 -> tab.text = "공지사항"
                1 -> tab.text = "행사일정"
                2 -> tab.text = "사진첩"
            }
        }.attach()
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel
    }

    override fun initListener() {
        super.initListener()
    }

    override fun afterOnCreate() {
        super.afterOnCreate()
    }
}