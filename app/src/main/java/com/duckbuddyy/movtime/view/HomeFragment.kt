package com.duckbuddyy.movtime.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.databinding.FragmentHomeBinding
import com.duckbuddyy.movtime.util.ResultAdapter
import com.duckbuddyy.movtime.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val results = homeViewModel.popularShows.value?.results ?: List<Result>()
        binding.viewmodel = homeViewModel
        binding.recyclerViewAdapter = ResultAdapter(results)
        binding.lifecycleOwner = this
        return binding.root
    }

}