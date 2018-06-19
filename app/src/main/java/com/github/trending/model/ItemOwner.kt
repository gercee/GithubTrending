package com.github.trending.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemOwner(val id: Int, val login: String, val avatarUrl: String) : Parcelable