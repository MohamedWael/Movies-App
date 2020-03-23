package com.github.mohamedwael.movieapp.applevel.network.networkservice

import com.github.mohamedwael.core.domain.ErrorHandler
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface NetworkService<Response, RestClient> {
    fun execute(
        observable: Observable<Response>,
        responseCallback: (Response) -> Unit,
        errorCallback: (ErrorHandler) -> Unit
    ): Disposable


    fun createRestClient(tClass: Class<RestClient>): RestClient
}