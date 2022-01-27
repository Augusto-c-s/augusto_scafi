package com.ascafi.projetomoviesmvvmkt.data.api

import com.ascafi.projetomoviesmvvmkt.data.vo.MovieDetails
import com.ascafi.projetomoviesmvvmkt.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/299534?api_key=fe5125e60fe4b0d70978071b51770ff8
    //https://api.themoviedb.org/3/movie/popular?api_key=fe5125e60fe4b0d70978071b51770ff8&page=1
    //https://api.themoviedb.org/3/

    @GET("movie/{movie_id}")
    //Single como se fosse o Observable no JAVA
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>

    @GET("movie/popular")
    fun getMoviePopular(@Query("page") page: Int): Single<MovieResponse>
}