package com.duckbuddyy.movtime.util

import android.view.View
import com.duckbuddyy.movtime.model.popular.Result

interface ResultItemClickListener {
    fun onResultItemClicked(view: View, result: Result)
}