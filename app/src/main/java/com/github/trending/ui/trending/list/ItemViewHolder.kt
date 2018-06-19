package com.github.trending.ui.trending.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.trending.model.TrendingItem
import com.github.trending.utils.ext.loadUrl
import kotlinx.android.synthetic.main.item_trending.view.description
import kotlinx.android.synthetic.main.item_trending.view.image
import kotlinx.android.synthetic.main.item_trending.view.title

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(item: TrendingItem, listener: (TrendingItem) -> Unit) = with(itemView) {
        title.text = item.title
        description.text = item.description
        image.loadUrl(item.owner.avatarUrl)
        setOnClickListener { listener(item) }
    }
}