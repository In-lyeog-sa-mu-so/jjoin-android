package org.donnguk.jjoin.base.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object ImageBindingAdapter {
    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun setProfileImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .apply(RequestOptions().fitCenter())
            .into(view)
    }
}