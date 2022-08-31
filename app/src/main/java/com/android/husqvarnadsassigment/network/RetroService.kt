package com.android.husqvarnadsassigment.network

import com.android.husqvarnadsassigment.models.MovieDetailsRecyclerData
import com.android.husqvarnadsassigment.models.MoviesRecyclerList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {

    @GET("popular")
    suspend fun getMovies(@Query("api_key") api_key : String): MoviesRecyclerList

    @GET("{movie_id}")
    suspend fun getMoviesDetails(
        @Path("movie_id") movie_id : Int,
        @Query("api_key") api_key : String

    ): MovieDetailsRecyclerData

}