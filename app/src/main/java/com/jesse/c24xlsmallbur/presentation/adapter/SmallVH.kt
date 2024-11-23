package com.jesse.c24xlsmallbur.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jesse.c24xlsmallbur.core.load
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import com.jesse.c24xlsmallbur.databinding.ItemSmallBinding

class SmallVH(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSmallBinding.bind(view)

    fun bind(smallResponseItem: SmallResponseItem, onItemSelected: (SmallResponseItem) -> Unit) {
        binding.name.text = smallResponseItem.name
        binding.img.load(smallResponseItem.image)
        binding.root.setOnClickListener { onItemSelected(smallResponseItem) }
    }
}