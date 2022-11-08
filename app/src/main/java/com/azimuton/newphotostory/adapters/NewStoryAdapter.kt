package com.azimuton.newphotostory.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.azimuton.domain.models.Photo
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.fragments.NewStoryFragment

class NewStoryAdapter(val contextA: Context,
                      val photoList: List<Photo>,
                      val callback: NewStoryFragment)
    : RecyclerView.Adapter<NewStoryAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        //val context = contextV
        var title: TextView? = null
        var image : ImageView? = null
        var deleteItem : ImageView? = null

        init{
            title = itemView.findViewById(R.id.tvItemAddPhoto)
            image  = itemView.findViewById(R.id.ivItemAddPhoto)
            deleteItem = itemView.findViewById(R.id.ivItemAddPhotoDelete)
        }
        interface ItemCallback {
            fun deleteItem(index: Int)
            fun onSelected(index:Int)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(contextA).inflate(R.layout.item_new_photo, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = photoList[position].dbphototitle
        holder.image?.setImageURI(photoList[position].dbphotoimage.toUri())
        holder.deleteItem?.setOnClickListener {
            callback.deleteItem(position)
        }
        holder.itemView.setOnClickListener {
            callback.onSelected(position)
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}