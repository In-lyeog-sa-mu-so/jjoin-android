package org.donnguk.jjoin.club.adapter

import android.content.res.Resources.NotFoundException
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.donnguk.jjoin.club.view.AlbumFragment
import org.donnguk.jjoin.club.view.NoticeFragment
import org.donnguk.jjoin.club.view.PlanFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NoticeFragment()
            1 -> PlanFragment()
            2 -> AlbumFragment()

            else -> {
                throw NotFoundException("Position Not Found")
            }
        }
    }
}