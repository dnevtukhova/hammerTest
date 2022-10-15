package com.lobzhanidze.ordering_burgers.presentation.view.recycler

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsearch.data.entity.ElementItem
import com.lobzhanidze.ordering_burgers.R

class ElementHolder(itemElement: View): RecyclerView.ViewHolder(itemElement) {

    private val image: ImageView = itemElement.findViewById(R.id.icon_img);
    private val headerName: TextView = itemElement.findViewById(R.id.header_name);
    private val content: TextView = itemElement.findViewById(R.id.content);
    private val price: TextView = itemElement.findViewById(R.id.price);

fun bind (item: ElementItem){
    headerName.text = item.nameRu
    content.text = item.nameRu + item.nameRu + item.nameRu + item.nameRu

    price.text = "от " + item.year + " р"

    Glide.with(image.context)
        .load(item.posterUrlPreview)
        .placeholder(R.drawable.ic_image_24)
        .error(R.drawable.ic_image_error_24)
        .centerCrop()
        .into(image)
}


}