package com.ascafi.projetomoviesmvvmkt.data.repository

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}


class NetworkState(val status: Status, val mgs: String) {

    companion object {
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val ENDLIST: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS,"Success")
            LOADING = NetworkState(Status.RUNNING,"Running")
            ERROR = NetworkState(Status.FAILED,"Error")
            ENDLIST = NetworkState(Status.FAILED, "FIM DA LISTA")
        }
    }

}