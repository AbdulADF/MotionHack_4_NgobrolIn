package com.abduladf.ngobrolin.ui.dashboard

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.CreatorItemBinding
import com.abduladf.ngobrolin.model.Creator
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

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
        val creator = creatorItems.get(position)
        val imageUrl = creator.profilePhoto
        CoroutineScope(Dispatchers.Main).launch {
            val bitmap = downloadImage(imageUrl)
            holder.creatorImage.setImageBitmap(bitmap)
        }
        if (creator != null) {
            holder.creatorName.text = creator.name
            holder.creatorProfession.text = creator.professions[0].name
        }
    }

    override fun getItemCount(): Int {
        return creatorItems?.size ?: 0
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.creator_image)
    }

    private suspend fun downloadImage(imageUrl: String): Bitmap? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(imageUrl)
            .build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            val inputStream = response.body?.byteStream()
            BitmapFactory.decodeStream(inputStream)
        }
    }
}