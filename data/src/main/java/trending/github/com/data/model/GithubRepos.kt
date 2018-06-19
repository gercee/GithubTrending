package com.github.trending.model

import com.google.gson.annotations.SerializedName
import trending.github.com.data.model.Item

data class GithubRepos(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<Item>
)