package com.github.trending.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TrendingItem(val id: Int,
                        val name: String,
                        val title: String,
                        val description: String,
                        val size: Int,
                        val watchersCount: Int,
                        val openIssuesCount: Int,
                        val forksCount: Int,
                        val language: String,
                        val owner: ItemOwner) : Parcelable