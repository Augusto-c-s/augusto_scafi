package com.ascafi.projetomoviesmvvmkt.ui.popular_movie

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import com.ascafi.projetomoviesmvvmkt.data.api.POST_PAGE
import com.ascafi.projetomoviesmvvmkt.data.api.TheMovieDBInterface
import com.ascafi.projetomoviesmvvmkt.data.repository.MovieDataSource
import com.ascafi.projetomoviesmvvmkt.data.repository.MovieDataSourceFactory
import com.ascafi.projetomoviesmvvmkt.data.repository.NetworkState
import com.ascafi.projetomoviesmvvmkt.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository( private val apiService: TheMovieDBInterface) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable) : LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService,compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory,config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource,NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState)
    }
}