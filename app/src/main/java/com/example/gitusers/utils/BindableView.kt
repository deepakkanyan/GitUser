package com.example.gitusers.utils

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindableView {
        @JvmStatic
        @BindingAdapter("userIcon")
        fun userIcon(view: AppCompatImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(view.context)
                    .load(it).apply(RequestOptions().circleCrop())
                    .into(view)
            }
        }

}