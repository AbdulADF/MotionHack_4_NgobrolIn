package com.abduladf.ngobrolin

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.abduladf.ngobrolin.placeholder.PlaceholderContent.PlaceholderItem
import com.abduladf.ngobrolin.databinding.FragmentCategoryBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.textView
        val contentView: ImageView = binding.imageView

        override fun toString(): String {
            return super.toString() + " '" + idView + "'"
        }
    }

}