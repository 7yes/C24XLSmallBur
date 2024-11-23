package com.jesse.c24xlsmallbur.core

import android.app.Activity
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

//Toast
fun Activity.toast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}

fun Fragment.toast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), text, length).show()
}

//Picasso
fun ImageView.load(url: String) {
    if (url.isNotEmpty()) {
        Picasso.get().load(url).into(this)
    }
}
