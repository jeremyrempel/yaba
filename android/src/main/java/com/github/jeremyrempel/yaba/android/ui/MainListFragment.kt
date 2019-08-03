package com.github.jeremyrempel.yaba.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.jeremyrempel.yaba.android.R

class MainListFragment : Fragment(R.layout.fragment_main) {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        ContentsResponseListAdapter {

        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

}