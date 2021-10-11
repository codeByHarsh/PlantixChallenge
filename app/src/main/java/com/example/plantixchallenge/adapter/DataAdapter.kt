package com.example.plantixchallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantixchallenge.R
import com.example.plantixchallenge.constants.Constants
import com.example.plantixchallenge.datamodel.DataModel
import de.hdodenhof.circleimageview.CircleImageView

class DataAdapter(var response: DataModel?, var context: Context) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.custom_layout, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (response?.rows?.get(position)?.imageHref != null || response?.rows?.get(position)?.title != null) {
            var img = response?.rows?.get(position)?.imageHref
            img = img?.replace("http", "https")
            Glide.with(context).load(img)
                .error(R.drawable.noimage)
                .into(holder.image!!)
            holder.title?.text = response?.rows?.get(position)?.title
        } else {
            holder.title?.text = Constants.NO_Title
        }


    }

    override fun getItemCount(): Int {
        return response?.rows?.size!!
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView? = null
        var image: CircleImageView? = null

        init {
            this.image = view.findViewById(R.id.image)
            this.title = view.findViewById(R.id.title)
        }
    }
}