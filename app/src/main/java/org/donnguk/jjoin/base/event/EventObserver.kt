package org.donnguk.jjoin.base.event

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit): androidx.lifecycle.Observer<Event<T>> {
    override fun onChanged(value: Event<T>) {
        value.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }
}