package org.donnguk.jjoin.club.view

import android.content.res.Resources
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import org.donnguk.jjoin.R
import org.donnguk.jjoin.base.view.BaseFragment
import org.donnguk.jjoin.club.adapter.AlbumAdapter
import org.donnguk.jjoin.club.util.AlbumGridSpacingItemDecoration
import org.donnguk.jjoin.club.viewmodel.AlbumViewModel
import org.donnguk.jjoin.databinding.FragmentAlbumBinding
class AlbumFragment : BaseFragment<FragmentAlbumBinding, AlbumViewModel>(R.layout.fragment_album) {
    override val viewModel: AlbumViewModel by lazy {
        AlbumViewModel.AlbumViewModelFactory().create(AlbumViewModel::class.java)
    }

    override fun initView() {
        super.initView()
        binding.albumRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = AlbumAdapter(
                onClickListener = { id ->
                    Toast.makeText(context, "Album Clicked : $id", Toast.LENGTH_SHORT).show()
                }
            )
            addItemDecoration(AlbumGridSpacingItemDecoration(3, spacing = 4f.fromDpToPx()))
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        binding.viewModel = viewModel
    }

    override fun initListener(view: View) {
        super.initListener(view)
        viewModel.albums.observe(viewLifecycleOwner) {
            (binding.albumRecyclerView.adapter as AlbumAdapter).submitList(it)
        }
    }

    override fun afterViewCreated(view: View) {
        super.afterViewCreated(view)
    }

    private fun Float.fromDpToPx(): Int =
        (this * Resources.getSystem().displayMetrics.density).toInt()
}