package org.donnguk.jjoin.club.view

import android.view.View
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.BaseFragment
import org.donnguk.jjoin.club.viewmodel.AlbumViewModel
import org.donnguk.jjoin.databinding.FragmentAlbumBinding
class AlbumFragment : BaseFragment<FragmentAlbumBinding, AlbumViewModel>(R.layout.fragment_album) {
    override val viewModel: AlbumViewModel by lazy {
        AlbumViewModel.AlbumViewModelFactory().create(AlbumViewModel::class.java)
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