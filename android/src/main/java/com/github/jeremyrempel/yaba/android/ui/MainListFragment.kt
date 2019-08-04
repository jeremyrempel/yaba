package com.github.jeremyrempel.yaba.android.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jeremyrempel.yaba.android.R
import com.github.jeremyrempel.yaba.android.data.ImageResponseRow
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.properties.Delegates

class MainListFragment : Fragment(R.layout.fragment_main) {

    private var isUpdating: Boolean by Delegates.observable(false) { _, _, isLoading ->
        loadingView.isGone = !isLoading
        recycler.isGone = isLoading
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = ContentsResponseListAdapter(::onRowSelected)

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

        val testData = listOf(
            ImageResponseRow("Row 1 title", "https://images.unsplash.com/photo-1564860737251-b4fd32d140e0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60"),
            ImageResponseRow("Row 2 title", "https://images.unsplash.com/photo-1564860737251-b4fd32d140e0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60")
        )

        isUpdating = false
        listAdapter.submitList(testData)
    }
}

fun onRowSelected(imageResponseRow: ImageResponseRow) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}