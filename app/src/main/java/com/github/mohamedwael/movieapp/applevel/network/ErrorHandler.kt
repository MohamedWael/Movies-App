package com.github.mohamedwael.movieapp.applevel.network

interface ErrorHandler {
    var errorMsgStringRes: Int
    var errorMsgString: String
    var throwable: Throwable?
}