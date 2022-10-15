package com.lobzhanidze.ordering_burgers.presentation.view.recyclerStock

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsearch.data.entity.ElementItem
import com.lobzhanidze.ordering_burgers.R

class StockHolder(stockElement: View): RecyclerView.ViewHolder(stockElement) {
    private val image: ImageView = stockElement.findViewById(R.id.imageStock);
    fun bind(item: ElementItem){
        Glide.with(image.context)
            .load(item.posterUrl)
            .placeholder(R.drawable.ic_image_24)
            .error(R.drawable.ic_image_error_24)
            .centerCrop()
            .into(image)
    }
}