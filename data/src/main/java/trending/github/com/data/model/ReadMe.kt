package trending.github.com.data.model

import com.google.gson.annotations.SerializedName

data class ReadMe(
    @SerializedName("name") val name: String,
    @SerializedName("path") val path: String,
    @SerializedName("sha") val sha: String,
    @SerializedName("size") val size: Int,
    @SerializedName("url") val url: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("git_url") val gitUrl: String,
    @SerializedName("download_url") val downloadUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("content") val content: String,
    @SerializedName("encoding") val encoding: String,
    @SerializedName("_links") val links: Links
)