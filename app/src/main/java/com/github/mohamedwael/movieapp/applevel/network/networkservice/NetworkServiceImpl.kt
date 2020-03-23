package io.thed.applevel.network.networkservice

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.github.mohamedwael.movieapp.applevel.network.ErrorHandler
import com.github.mohamedwael.movieapp.applevel.network.ErrorHandlerImpl
import com.github.mohamedwael.movieapp.applevel.network.RestClient
import com.github.mohamedwael.movieapp.applevel.network.Retrofit

open class NetworkServiceImpl<Response, RestClient> : NetworkService<Response, RestClient> {

    override fun execute(
        observable: Observable<Response>,
        responseCallback: (Response) -> Unit,
        errorCallback: (ErrorHandler) -> Unit
    ): Disposable = observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            responseCallback(it)
        }, { errorCallback(ErrorHandlerImpl(it)) })


    override fun createRestClient(tClass: Class<RestClient>): RestClient {
        return Retrofit.createClient(tClass)
    }
}

fun <Response> network(service: NetworkService<Response, RestClient>.() -> Unit): NetworkService<Response, RestClient> {
    val networkService = NetworkServiceImpl<Response, RestClient>()
    service(networkService)
    return networkService
}