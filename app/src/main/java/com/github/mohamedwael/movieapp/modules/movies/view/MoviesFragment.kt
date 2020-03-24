package com.github.mohamedwael.movieapp.modules.movies.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.mowael.baselibrary.contract.ErrorMessageHandler
import com.blogspot.mowael.baselibrary.fragments.BaseFragment

import com.github.mohamedwael.movieapp.databinding.MoviesFragmentBinding
import com.github.mohamedwael.movieapp.modules.movies.adapter.MoviesAdapter
import com.github.mohamedwael.movieapp.modules.movies.viewmodel.MoviesViewModel
import com.github.mohamedwael.movieapp.modules.movies.viewmodel.MoviesViewModelFactory

class MoviesFragment : BaseFragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MoviesFragmentBinding.inflate(layoutInflater, container, false)
        binding.rvMovies.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProviders.of(this, MoviesViewModelFactory).get(MoviesViewModel::class.java)
        viewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            binding.rvMovies.adapter = MoviesAdapter(it)
        })
        observeOnLiveDataEvents()

        viewModel.getData()
        return binding.root
    }

    private fun observeOnLiveDataEvents() {
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
