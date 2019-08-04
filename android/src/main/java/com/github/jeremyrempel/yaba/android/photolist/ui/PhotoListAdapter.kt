package com.github.jeremyrempel.yaba.android.photolist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.jeremyrempel.yaba.android.R
import com.github.jeremyrempel.yaba.android.data.ListPhotoResponseRow
import kotlinx.android.synthetic.main.row_list.view.*

class PhotoListAdapter(private val callback: (ListPhotoResponseRow) -> Unit) :
    ListAdapter<ListPhotoResponseRow, PhotoListAdapter.MyViewHolder>(
        TaskDiffCallback()
    ) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(getItem(position), callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_list, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(row: ListPhotoResponseRow, callback: (ListPhotoResponseRow) -> Unit) {

            view.txt_title.text = row.title

            Glide
                .with(view.context)
                .load(row.imageUrl)
                .centerCrop()
                .into(view.image_view)

            view.setOnClickListener { callback.invoke(row) }
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<ListPhotoResponseRow>() {
        override fun areItemsTheSame(
            oldItem: ListPhotoResponseRow,
            newItem: ListPhotoResponseRow
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ListPhotoResponseRow,
            newItem: ListPhotoResponseRow
        ): Boolean = oldItem == newItem
    }
}