package com.github.mohamedwael.movieapp.modules.movies.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mohamedwael.movieapp.base.MoviesBaseFragment

import com.github.mohamedwael.movieapp.databinding.MoviesFragmentBinding
import com.github.mohamedwael.movieapp.modules.movies.adapter.MoviesAdapter
import com.github.mohamedwael.movieapp.modules.movies.viewmodel.MoviesViewModel
import com.github.mohamedwael.movieapp.modules.movies.viewmodel.MoviesViewModelFactory

class MoviesFragment : MoviesBaseFragment() {

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MoviesFragmentBinding.inflate(layoutInflater, container, false)
        binding.rvMovies.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProviders.of(this, MoviesViewModelFactory).get(MoviesViewModel::class.java)
        observeOnFragmentEvents(viewModel)
        viewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            binding.rvMovies.adapter = MoviesAdapter(it)
        })
        viewModel.getData()
        return binding.root
    }
}
