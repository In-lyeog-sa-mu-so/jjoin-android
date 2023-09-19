package org.donnguk.jjoin.club.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.BaseViewModel

class AlbumViewModel: BaseViewModel() {
    class AlbumViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AlbumViewModel() as T
        }
    }
}