package org.donnguk.jjoin.club.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.club.model.Album

class AlbumViewModel: BaseViewModel() {
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    init {
        _albums.value = listOf(
            Album(
                id = 1,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 2,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 3,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 4,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 5,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 6,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 7,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 8,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 9,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
            Album(
                id = 10,
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
            ),
        )
    }

    class AlbumViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AlbumViewModel() as T
        }
    }
}