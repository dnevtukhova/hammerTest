package com.lobzhanidze.ordering_burgers.presentation.view.recyclerStock

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsearch.data.entity.ElementItem
import com.lobzhanidze.ordering_burgers.R

class StockAdapter(
    private val inflater: LayoutInflater
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = arrayListOf<ElementItem>()

    fun setItems(films: ArrayList<ElementItem>) {
        items.clear()
        items.addAll(films)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StockHolder(inflater.inflate(R.layout.stock_element, parent, false))
    }

    override fun onBindViewHolder(stock: RecyclerView.ViewHolder, position: Int) {
        if (stock is StockHolder) {
            val item = items[position]
            stock.bind(item)
        }
    }

    override fun getItemCount() = items.size

}