package com.duckbuddyy.movtime.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.databinding.FragmentDetailBinding
import com.duckbuddyy.movtime.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel { parametersOf(args.tvId) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.viewmodel = detailViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}