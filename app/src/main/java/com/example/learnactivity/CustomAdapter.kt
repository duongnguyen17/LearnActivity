package com.example.learnactivity

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: Array<DataName>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_nameItem)
        val imageView: ImageView = view.findViewById(R.id.imv_imageItem)


        fun bind(data: DataName) {
            // gan du lieu
            textView.text = data.name
            imageView.setImageURI(Uri.parse(data.imageUrl))
        }
    }

    // cần override lại 3 method

    // calls this method whenever it needs to create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tag_name_item, parent, false)
//        Log.d(TAG, "onCreateViewHolder: ")
        return ViewHolder(view)
    }

    // calls this method to associate a ViewHolder with data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.d(TAG, "onBindViewHolder: ")
        holder.bind(dataSet[position])
    }

    // calls this method to get the size of the data set
    override fun getItemCount(): Int = dataSet.size
}