package com.github.mohamedwael.movieapp.modules.splash

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation

import com.github.mohamedwael.movieapp.R

class SplashScreenFragment : Fragment() {

    companion object {
        fun newInstance() = SplashScreenFragment()
    }

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_screen_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashScreenViewModel::class.java)
        viewModel.moveToNextScreen.observe(viewLifecycleOwner, Observer {
            if (it) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_splashScreenFragment_to_moviesFragment)
            }
        })
        viewModel.startSplashTimer()
    }

}
