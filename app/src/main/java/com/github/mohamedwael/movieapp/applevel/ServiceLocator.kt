package com.github.mohamedwael.movieapp.applevel

/**
 * This service locator wil act as a replacment for the dependency injection for simplicity
 */
object ServiceLocator {
    private var serviceMap: MutableMap<String, Any> = mutableMapOf()

    fun addService(key: String, value: Any) {
        serviceMap[key] = value
    }

    fun retrieveService(key: String) =
        checkNotNull(serviceMap[key]) { "Service associated with the key: $key is not found!" }

}