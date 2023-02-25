package com.abduladf.ngobrolin.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.CreatorItemBinding
import com.abduladf.ngobrolin.model.Creator

class CreatorItemAdapter(private val creatorItems: List<Creator>) : RecyclerView.Adapter<CreatorItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CreatorItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val creatorName: TextView = binding.creatorName
        val creatorImage: ImageView = binding.creatorImage
        val creatorProfession: TextView = binding.creatorProfession
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CreatorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val creator = creatorItems?.get(position)
        if (creator != null) {
            holder.creatorName.text = creator.name
            holder.creatorProfession.text = creator.professions[0].name
        }
    }

    override fun getItemCount(): Int {
        return creatorItems?.size ?: 0
    }

}