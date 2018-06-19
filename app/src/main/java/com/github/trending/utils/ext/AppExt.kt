package com.github.trending.utils.ext

import com.github.trending.model.GithubRepos
import com.github.trending.model.ItemOwner
import com.github.trending.model.TrendingItem
import trending.github.com.data.model.Item
import trending.github.com.data.model.Owner

fun Item.toTrendingItem() : TrendingItem {
    return TrendingItem(this.id,
                        this.name,
                        this.fullName,
                        this.description,
                        this.size,
                        this.watchers,
                        this.openIssuesCount,
                        this.forksCount,
                        this.language,
                        this.owner.toItemOwner())
}

fun Owner.toItemOwner() : ItemOwner {
    return ItemOwner(this.id, this.login, this.avatarUrl)
}

fun GithubRepos.toTrendingList(): List<TrendingItem>{
    return items.map { it -> it.toTrendingItem() }
}