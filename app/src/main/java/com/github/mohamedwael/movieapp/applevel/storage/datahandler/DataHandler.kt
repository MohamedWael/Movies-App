package com.github.mohamedwael.movieapp.applevel.storage.datahandler

import androidx.lifecycle.LiveData
import com.github.mohamedwael.movieapp.applevel.storage.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class DataHandler<Data>(val database: AppDatabase) {

    abstract fun insertItem(data: Data, onSuccess: () -> Unit)

    abstract fun insertAll(data: List<Data>, onSuccess: () -> Unit)

    abstract fun update(data: Data, onSuccess: () -> Unit)

    abstract fun delete(data: Data, onSuccess: () -> Unit)

    abstract fun deleteAll(onSuccess: () -> Unit)

    abstract fun getItems(): LiveData<List<Data>>

    abstract fun getItem(): LiveData<Data>

    abstract fun getItemByParam(param: Any): LiveData<Data>

    fun <T> doAsync(action: () -> T, onSuccess: () -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            action()
            withContext(Dispatchers.Main) {
                onSuccess()
            }
        }
    }

    fun throwUnsupportedOperationException() {
        throw UnsupportedOperationException("this method is not implemented and may not be used")
    }
}
