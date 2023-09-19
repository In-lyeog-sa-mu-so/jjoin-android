package org.donnguk.jjoin.main.view

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.BaseFragment
import org.donnguk.jjoin.databinding.FragmentProfileBinding
import org.donnguk.jjoin.main.adapter.JoinedClubAdapter
import org.donnguk.jjoin.main.viewmodel.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {
    override val viewModel: ProfileViewModel by lazy {
        ProfileViewModel.ProfileViewModelFactory().create(ProfileViewModel::class.java)
    }

    override fun initView() {
        super.initView()
        binding.joinedClubRecyclerView.apply {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = JoinedClubAdapter(
            clickCallback = { id: Int ->
                Toast.makeText(context, "클럽 아이디: $id", Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel
    }

    override fun initListener(view: View) {
        super.initListener(view)
        viewModel.joinedClubs.observe(viewLifecycleOwner) {
            (binding.joinedClubRecyclerView.adapter as JoinedClubAdapter).submitList(it)
        }
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }
}