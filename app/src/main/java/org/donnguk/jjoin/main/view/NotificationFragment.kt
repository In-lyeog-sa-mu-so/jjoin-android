package org.donnguk.jjoin.main.view

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.donnguk.jjoin.base.BaseFragment
import org.donnguk.jjoin.R
import org.donnguk.jjoin.databinding.FragmentNotificationBinding
import org.donnguk.jjoin.main.adapter.NotificationAdapter
import org.donnguk.jjoin.main.viewmodel.NotificationViewModel

class NotificationFragment : BaseFragment<FragmentNotificationBinding, NotificationViewModel>(R.layout.fragment_notification) {
    override val viewModel: NotificationViewModel by lazy {
        NotificationViewModel.NotificationViewModelFactory().create(NotificationViewModel::class.java)
    }

    override fun initView() {
        super.initView()

        binding.notificationRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NotificationAdapter(
                clickCallback = {id ->
                    viewModel.readNotification(id)
                }
            )
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            setHasFixedSize(true)
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel
    }

    override fun initListener(view: View) {
        super.initListener(view)

        viewModel.notificationList.observe(viewLifecycleOwner) {
            (binding.notificationRecyclerView.adapter as NotificationAdapter).submitList(it)
        }
    }
}