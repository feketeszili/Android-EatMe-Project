package com.example.eatme.userInterface

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eatme.MainActivity
import com.example.eatme.R
import com.example.eatme.model.Restaurant
import com.example.eatme.util.Constants.Companion.favList


class MyAdapter(): RecyclerView.Adapter<MyHolder>() {

    private var dataList: List<Restaurant> = emptyList()
    private lateinit var context: Context


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
         return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
     }

     override fun onBindViewHolder(holder: MyHolder, position: Int) {

         val data = dataList[position]
         holder.name.text = data.name
         holder.country.text = data.country

         val detailsFragment = DetailsFragment()

         holder.image.setOnClickListener {
             val address = data.address
             val area = data.area
             val city = data.city
             val country = data.country
             val id = data.id
             val imageUrl = data.image_url
             val lat = data.lat
             val lng = data.lng
             val mobilReserveUrl = data.mobile_reserve_url
             val name = data.name
             val phone = data.phone
             val postalCode = data.postal_code
             val price = data.price
             val reserveUrl = data.reserve_url
             val state = data.state
             val bundle = bundleOf(
                 "address" to address,
                 "area" to area,
                 "city" to city,
                 "country" to country,
                 "id" to id,
                 "imageUrl" to imageUrl,
                 "lat" to lat,
                 "lng" to lng,
                 "mobile_reserve_url" to mobilReserveUrl,
                 "name" to name,
                 "phone" to phone,
                 "postal_code" to postalCode,
                 "price" to price,
                 "reserve_url" to reserveUrl,
                 "state" to state
             )
             detailsFragment.arguments = bundle
             switchContent(R.id.NavigationHostFragment, detailsFragment)
         }

         holder.image.setOnLongClickListener {
             favList.add(data)
             Log.d("lista", favList.get(0).toString())
             Toast.makeText(context,"Added to favourites",Toast.LENGTH_SHORT).show()
             true
         }

         // We can load the images from backend with glide
         //Glide.with(context).load(data.image_url).into(holder.image)

     }

    fun switchContent(id: Int, fragment: Fragment) {
        if (context is MainActivity) {
            val mainActivity = context as MainActivity
            val frag: Fragment = fragment
            mainActivity.switchContent(id, frag)
        }
    }

    fun setData(list: List<Restaurant>){
        this.dataList = list
        notifyDataSetChanged()

    }

     override fun getItemCount(): Int = dataList.size
 }

