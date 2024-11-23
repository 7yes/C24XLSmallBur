package com.jesse.c24xlsmallbur.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesse.c24xlsmallbur.R
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem

class SmallAdapter(
    private val lista: List<SmallResponseItem>,
    private val onItemSelected: (SmallResponseItem) -> Unit
) :
    RecyclerView.Adapter<SmallVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SmallVH(layoutInflater.inflate(R.layout.item_small, parent, false))
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: SmallVH, position: Int) {
        holder.bind(lista[position], onItemSelected)
    }
}