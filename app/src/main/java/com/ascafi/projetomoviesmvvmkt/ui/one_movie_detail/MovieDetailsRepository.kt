package com.ascafi.projetomoviesmvvmkt.ui.one_movie_detail

import androidx.lifecycle.LiveData
import com.ascafi.projetomoviesmvvmkt.data.api.TheMovieDBInterface
import com.ascafi.projetomoviesmvvmkt.data.repository.MovieDetailsNetworkDataSource
import com.ascafi.projetomoviesmvvmkt.data.repository.NetworkState
import com.ascafi.projetomoviesmvvmkt.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}