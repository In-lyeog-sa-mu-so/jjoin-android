package org.donnguk.jjoin.main.view

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import org.donnguk.jjoin.base.BaseFragment
import org.donnguk.jjoin.R
import org.donnguk.jjoin.databinding.FragmentHomeBinding
import org.donnguk.jjoin.main.adapter.AccededClubCardAdapter
import org.donnguk.jjoin.main.adapter.ClubCardAdapter
import org.donnguk.jjoin.main.adapter.ScheduleCardAdapter
import org.donnguk.jjoin.main.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by lazy {
        HomeViewModel.HomeViewModelFactory().create(HomeViewModel::class.java)
    }

    override fun initView() {
        super.initView()
        binding.clubCardViewPager.apply {
            // pageMargin 설정
            val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
            val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()
            setPageTransformer { page, position ->
                val myOffset = position * -(2 * pageOffset + pageMargin)
                if (position < -1) {
                    page.translationX = -myOffset
                } else if (position <= 1) {
                    page.translationX = myOffset
                } else {
                    page.translationX = myOffset
                }
            }

            // 로딩 1개 설정
            offscreenPageLimit = 1
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }.run {
            // ViewPager2는 RecyclerView의 Adapter 사용
            adapter = AccededClubCardAdapter(
                detailCallback = { id: Int ->
                    Toast.makeText(context, "detailCallback $id", Toast.LENGTH_SHORT).show()
                },
                shareCallback = { id: Int ->
                    Toast.makeText(context, "shareCallback $id", Toast.LENGTH_SHORT).show()
                },
                exitCallback = { id: Int ->
                    Toast.makeText(context, "exitCallback $id", Toast.LENGTH_SHORT).show()
                },
            )
        }
        binding.dotsIndicator.attachTo(binding.clubCardViewPager)

        binding.noSelectScheduleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ScheduleCardAdapter(
                agreeCallback = { id: Int ->
                    Toast.makeText(context, "agreeCallback $id", Toast.LENGTH_SHORT).show()
                },
                disAgreeCallback = { id: Int ->
                    Toast.makeText(context, "disAgreeCallback $id", Toast.LENGTH_SHORT).show()
                },
            )
            setHasFixedSize(true)
        }

        binding.recommendClubRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ClubCardAdapter(
                clickCallback = { id: Int ->
                    Toast.makeText(context, "clickCallback $id", Toast.LENGTH_SHORT).show()
                },
            )
            setHasFixedSize(true)
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel
    }

    override fun initListener(view: View) {
        super.initListener(view)
        viewModel.scheduleCards.observe(viewLifecycleOwner) {
            (binding.noSelectScheduleRecyclerView.adapter as ScheduleCardAdapter).submitList(it)
        }

        viewModel.accededClubCards.observe(viewLifecycleOwner) {
            (binding.clubCardViewPager.adapter as AccededClubCardAdapter).submitList(it)
        }

        viewModel.clubCards.observe(viewLifecycleOwner) {
            (binding.recommendClubRecyclerView.adapter as ClubCardAdapter).submitList(it)
        }
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }
}