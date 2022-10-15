package com.lobzhanidze.ordering_burgers.presentation.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(var offset: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = offset;
        outRect.right = offset;
        outRect.bottom = offset;
        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.top = offset;
        }
    }
}