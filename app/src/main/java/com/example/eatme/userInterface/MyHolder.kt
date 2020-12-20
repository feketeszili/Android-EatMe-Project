package com.example.eatme.userInterface

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eatme.R
import kotlinx.android.synthetic.main.item_view.view.*

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView = itemView.findViewById(R.id.name)
    val country: TextView = itemView.findViewById(R.id.country)
    val image: ImageView = itemView.findViewById(R.id.avatar)
}