package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.base.event.Event

class MainViewModel: BaseViewModel() {
    companion object {
        enum class EventTag {
            NONE
        }
    }

    private val _event = MutableLiveData<Event<Unit>>();
    val event: LiveData<Event<Unit>> = _event
    var eventTag: EventTag = EventTag.NONE
        private set

    fun onClickEvent(tag: EventTag) {
        _event.value = Event(Unit);
    }


    class MainViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel() as T
        }
    }
}