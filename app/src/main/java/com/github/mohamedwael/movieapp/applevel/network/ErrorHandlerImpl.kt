package com.github.mohamedwael.movieapp.applevel.network

import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.movieapp.R
import com.google.gson.stream.MalformedJsonException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

const val BAD_REQUEST = 400
const val UNAUTHORIZED = 401
const val INTERNAL_SERVER_ERROR = 500

class ErrorHandlerImpl(throwable: Throwable) :
    ErrorHandler {
    override var errorMsgStringRes: Int = 0
    override var errorMsgString: String = ""
    override var throwable: Throwable? = null

    init {
        errorMsgStringRes = when (throwable) {
            is UnknownHostException -> R.string.no_connection
            is SocketTimeoutException -> R.string.connection_error
            is ConnectException -> R.string.connect_exception
            is MalformedJsonException -> R.string.internal_fix
            is HttpException -> {
                if (throwable.message?.isNotEmpty() == true) {
                    errorMsgString = throwable.message!!
                }
                getErrorMessage(throwable.code())


            }
            else -> R.string.something_went_wrong
        }
    }

    private fun getErrorMessage(code: Int): Int {
        return  mapOf(
            Pair(BAD_REQUEST, R.string.bad_request),
            Pair(INTERNAL_SERVER_ERROR, R.string.server_error),
            Pair(UNAUTHORIZED, R.string.unauthorized)
        ).getOrElse(code) {
            R.string.something_went_wrong
        }
    }
}