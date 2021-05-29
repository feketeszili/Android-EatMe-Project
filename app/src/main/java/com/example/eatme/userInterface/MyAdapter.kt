package com.example.eatme.userInterface

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eatme.R
import com.example.eatme.model.Restaurant
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(): RecyclerView.Adapter<MyHolder>() {

     private var dataList: List<Restaurant> = emptyList()
    //private var dataList = emptyList<Restaurant>()
    private lateinit var context: Context


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
         return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
     }
// oncreateviewholderben deklaralni mindent és idt adni

     override fun onBindViewHolder(holder: MyHolder, position: Int) {

         val data = dataList[position]
         holder.name.text = data.name
         holder.country.text = data.country

         // glide
         Glide.with(context).load(data.image_url).into(holder.image)

     }
    fun setData(list : List<Restaurant>){
        this.dataList = list
        notifyDataSetChanged()

    }

     override fun getItemCount(): Int = dataList.size
 }