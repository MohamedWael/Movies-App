package com.github.mohamedwael.core.domain

interface ErrorHandler {
    var errorMsgStringRes: Int
    var errorMsgString: String
    var throwable: Throwable?
}