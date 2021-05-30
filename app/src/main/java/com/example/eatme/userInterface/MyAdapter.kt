package com.example.eatme.userInterface

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eatme.MainActivity
import com.example.eatme.R
import com.example.eatme.model.Restaurant
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.view.*


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

         //val mainActivity = (activity as MainActivity)
         //holder.image.setOnClickListener { mainActivity.makeCurrentFragment(detailsFragment) }

         holder.image.setOnClickListener(View.OnClickListener { fragmentJump(position) })


         // We can load the images from backend with glide
         //Glide.with(context).load(data.image_url).into(holder.image)

     }

    private fun fragmentJump(mItemSelected: Int) {
        val detailsFragment = DetailsFragment()
        //val bundle = Bundle()
        //bundle.putParcelable("item_selected_key", mItemSelected)
        //detailsFragment.setArguments(bundle)
        switchContent(R.id.NavigationHostFragment, detailsFragment)
    }

    fun switchContent(id: Int, fragment: Fragment) {
        if (context == null) return
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

private fun View.setOnClickListener(onClickListener: View.OnClickListener, function: () -> Unit) {

}
