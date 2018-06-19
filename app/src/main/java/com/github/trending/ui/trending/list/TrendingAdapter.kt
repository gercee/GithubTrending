package com.github.trending.ui.trending.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.github.trending.R
import com.github.trending.model.TrendingItem
import com.github.trending.ui.trending.TrendingContract


class TrendingAdapter(private val listener: ItemListener, private val data: List<TrendingItem>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_trending, null)
        return ItemViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position], {
            listener.onItemClicked(it, holder.itemView)
        })
    }
}