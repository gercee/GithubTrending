package com.github.trending.ui.trending.list

import android.view.View
import com.github.trending.model.TrendingItem

interface ItemListener{
    fun onItemClicked(item: TrendingItem, view: View)
}