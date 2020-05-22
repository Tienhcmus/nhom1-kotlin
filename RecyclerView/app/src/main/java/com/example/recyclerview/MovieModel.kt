package com.example.recyclerview

import android.os.Parcel
import android.os.Parcelable
import android.service.quicksettings.Tile
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieModel(
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val id: Double,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val title: String,
    val vote_average: Float,
    val overview: String,
    val release_date: String) : Parcelable {
    fun getURL(): String {
        var url:String = "https://image.tmdb.org/t/p/w500/"
        url = url.plus(poster_path)
        return url
    }

}