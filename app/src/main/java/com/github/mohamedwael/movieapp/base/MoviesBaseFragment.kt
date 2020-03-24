package com.github.mohamedwael.movieapp.base

import androidx.lifecycle.Observer
import com.blogspot.mowael.baselibrary.contract.ErrorMessageHandler
import com.blogspot.mowael.baselibrary.fragments.BaseFragment

open class MoviesBaseFragment : BaseFragment() {

    fun observeOnFragmentEvents(viewModel: MoviesBaseViewModel) {
        viewModel.showErrorLiveData.observe(viewLifecycleOwner, Observer {
            showSnakeMessage(object : ErrorMessageHandler {
                override fun getMessage(): String = it.errorMsgString
                override fun getMessageRes(): Int = it.errorMsgStringRes
            })
        })
        viewModel.showLoadingLiveData.observe(viewLifecycleOwner, Observer {
            if (it) {
                showProgressDialog()
            } else {
                hideProgressDialog()
            }
        })
    }
}