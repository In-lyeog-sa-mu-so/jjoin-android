package org.donnguk.jjoin.main.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseFragment
import org.donnguk.jjoin.club.view.ClubDetailActivity
import org.donnguk.jjoin.databinding.FragmentProfileBinding
import org.donnguk.jjoin.main.adapter.JoinedClubAdapter
import org.donnguk.jjoin.main.viewmodel.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {
    override val viewModel: ProfileViewModel by lazy {
        ProfileViewModel.ProfileViewModelFactory().create(ProfileViewModel::class.java)
    }
    private val REQ_PERMISSION_PUSH = 123

    override fun initView() {
        super.initView()
        binding.joinedClubRecyclerView.run {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = JoinedClubAdapter(
            clickCallback = { id: Int ->
                //Toast.makeText(context, "클럽 아이디: $id", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(context, ClubDetailActivity::class.java).apply {
                    putExtra("id", id)
                }
                startActivity(intent)
            })
        }

        binding.editProfileButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileEditFragment)
        }

        binding.noticifacionSwitch.setOnCheckedChangeListener{
            _, isChecked ->
            if(isChecked){
                Toast.makeText(context, "알림이 켜졌습니다.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "알림이 꺼졌습니다.", Toast.LENGTH_SHORT).show()
            }
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