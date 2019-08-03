package com.github.jeremyrempel.yaba.android.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.jeremyrempel.yaba.android.R
import com.github.jeremyrempel.yaba.android.data.ImageResponseRow

class ContentsResponseListAdapter(private val callback: (ImageResponseRow) -> Unit) :
    ListAdapter<ImageResponseRow, ContentsResponseListAdapter.MyViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(getItem(position), callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_list, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(row: ImageResponseRow, callback: (ImageResponseRow) -> Unit) {

            view.setOnClickListener { callback.invoke(row) }
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<ImageResponseRow>() {
        override fun areItemsTheSame(oldItem: ImageResponseRow, newItem: ImageResponseRow): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ImageResponseRow, newItem: ImageResponseRow): Boolean =
            oldItem == newItem
    }
}