package com.github.mohamedwael.movieapp.modules.moviedetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.mohamedwael.movieapp.applevel.MOVIE_ID
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem
import com.github.mohamedwael.movieapp.base.MoviesBaseFragment
import com.github.mohamedwael.movieapp.databinding.MovieDetailsFragmentBinding
import com.github.mohamedwael.movieapp.modules.moviedetails.viewmodel.MovieDetailsViewModel
import com.github.mohamedwael.movieapp.modules.moviedetails.viewmodel.MovieDetailsViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MovieDetailsFragment : MoviesBaseFragment() {

    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this, MovieDetailsViewModelFactory)
            .get(MovieDetailsViewModel::class.java)
        observeOnFragmentEvents(viewModel)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        val sheetBehavior = BottomSheetBehavior.from(binding.bottomSheet);
        sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                }
            }

        })


        viewModel.getMovieById(arguments?.getInt(MOVIE_ID))
        return binding.root
    }
}
