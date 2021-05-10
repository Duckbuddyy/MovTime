package com.duckbuddyy.movtime.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.databinding.FragmentHomeBinding
import com.duckbuddyy.movtime.util.ResultAdapter
import com.duckbuddyy.movtime.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        //TODO
        lateinit var resultAdapter: ResultAdapter
        binding.recyclerViewHome.apply {
            layoutManager = LinearLayoutManager(context)
            val decoration =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            resultAdapter = ResultAdapter()
            adapter = resultAdapter
        }
        lifecycleScope.launchWhenCreated {
            homeViewModel.getListData().collectLatest {
                resultAdapter.submitData(it)
            }
        }


        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}