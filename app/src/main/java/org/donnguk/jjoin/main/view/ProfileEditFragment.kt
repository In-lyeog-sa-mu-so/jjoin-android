package org.donnguk.jjoin.main.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseFragment
import org.donnguk.jjoin.club.view.ClubDetailActivity
import org.donnguk.jjoin.databinding.FragmentProfileEditBinding
import org.donnguk.jjoin.main.adapter.JoinedClubAdapter
import org.donnguk.jjoin.main.viewmodel.ProfileEditViewModel

class ProfileEditFragment : BaseFragment<FragmentProfileEditBinding, ProfileEditViewModel>(R.layout.fragment_profile_edit) {
    override val viewModel: ProfileEditViewModel by lazy {
        ProfileEditViewModel()
    }

    override fun initView() {
        super.initView()
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel

        binding.editProfileImageButton.setOnClickListener {
            Toast.makeText(context, "프로필 사진을 변경합니다.", Toast.LENGTH_SHORT).show()
            
        }
    }

    override fun initListener(view: View) {
        super.initListener(view)
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }

    private fun navigateBackToProfile() {
        requireActivity().supportFragmentManager.popBackStack() // 이전의 프래그먼트로 돌아감
    }

}