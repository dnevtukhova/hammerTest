package com.lobzhanidze.ordering_burgers.presentation.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsearch.data.entity.ElementItem
import com.lobzhanidze.ordering_burgers.R

class ElementAdapter(
    private val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = arrayListOf<ElementItem>()

    fun setItems(films: ArrayList<ElementItem>) {
        items.clear()
        items.addAll(films)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ElementHolder(inflater.inflate(R.layout.item_element, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ElementHolder) {
            val item = items[position]
            holder.bind(item)
        }
    }

    override fun getItemCount() = items.size
}