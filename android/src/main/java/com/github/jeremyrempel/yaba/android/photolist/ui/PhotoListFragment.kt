package com.github.jeremyrempel.yaba.android.photolist.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jeremyrempel.yaba.android.R
import com.github.jeremyrempel.yaba.android.data.ListPhotoResponseRow
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject
import kotlin.properties.Delegates

class PhotoListFragment @Inject constructor(
    private val vmFactory: ViewModelProvider.Factory
) : Fragment(R.layout.fragment_main) {

    private val viewModel: PhotoListViewModel by viewModels { vmFactory }
    private lateinit var listAdapter: PhotoListAdapter

    private var isUpdating: Boolean by Delegates.observable(false) { _, _, isLoading ->
        loadingView.isGone = !isLoading
        recycler.isGone = isLoading
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter =
            PhotoListAdapter(::onRowSelected)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = listAdapter

            val dividerItemDecoration = DividerItemDecoration(
                context,
                linearLayoutManager.orientation
            )
            addItemDecoration(dividerItemDecoration)
        }

        listenForChanges()
    }

    private fun listenForChanges() {
        viewModel.getData().observe(this, Observer { onUpdate(it) })
        viewModel.showLoading().observe(this, Observer { isUpdating = it })
    }

    private fun onUpdate(data: List<ListPhotoResponseRow>) {
        listAdapter.submitList(data)
    }

    fun onRowSelected(imageResponseRow: ListPhotoResponseRow) {
        Log.d("PhotoListFragment", "Row clicked. $imageResponseRow")
    }
}