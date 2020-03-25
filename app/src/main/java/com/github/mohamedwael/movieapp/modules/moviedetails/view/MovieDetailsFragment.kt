package com.github.mohamedwael.movieapp.modules.moviedetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.github.mohamedwael.movieapp.applevel.MOVIE_ID
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
                //not needed
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        hideSheetTitle(binding)
                        showScreenTitle(binding)
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        showSheetTitle(binding)
                        hideScreenTitle(binding)
                    }
                }
            }

        })
        viewModel.getMovieById(arguments?.getInt(MOVIE_ID))
        return binding.root
    }

    private fun showScreenTitle(binding: MovieDetailsFragmentBinding) {
        binding.tvMovieTitle.animate().alpha(1.0f)
    }

    private fun showSheetTitle(binding: MovieDetailsFragmentBinding) {
        binding.tvSheetMovieTitle.animate().alpha(1.0f)
    }

    private fun hideScreenTitle(binding: MovieDetailsFragmentBinding) {
        binding.tvMovieTitle.animate().alpha(0f)
    }

    private fun hideSheetTitle(binding: MovieDetailsFragmentBinding) {
        binding.tvSheetMovieTitle.animate().alpha(0f)
    }
}
