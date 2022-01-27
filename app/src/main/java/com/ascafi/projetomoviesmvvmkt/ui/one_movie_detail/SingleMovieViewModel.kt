package com.ascafi.projetomoviesmvvmkt.ui.one_movie_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ascafi.projetomoviesmvvmkt.data.repository.NetworkState
import com.ascafi.projetomoviesmvvmkt.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository : MovieDetailsRepository, movieId: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails : LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    //onCleared é para limpar as requisições que foram feitas
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}