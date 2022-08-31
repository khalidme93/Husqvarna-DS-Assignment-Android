package com.android.husqvarnadsassigment.models

data class MoviesRecyclerList(val results: ArrayList<MoviesRecyclerData>)
data class MoviesRecyclerData(val title : String, val id: Int, val poster_path: String)

