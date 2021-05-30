package com.example.eatme.userInterface

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.eatme.R
import kotlinx.android.synthetic.main.activity_splash.view.*
import kotlinx.android.synthetic.main.fragment_details.view.*


class DetailsFragment : Fragment() {

    private lateinit var myView: View
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myView = inflater.inflate(R.layout.fragment_details, container, false)

        val address = requireArguments().get("address").toString()
        val area = requireArguments().get("area").toString()
        val city = requireArguments().get("city").toString()
        val country = requireArguments().get("country").toString()
        val id = requireArguments().get("id").toString()
        val imageUrl  = requireArguments().get("image_url").toString()
        val lat = requireArguments().get("lat").toString()
        val lng = requireArguments().get("lng").toString()
        val mobilReserveUrl = requireArguments().get("mobile_reserve_url").toString()
        val name = requireArguments().get("name").toString()
        val phone = requireArguments().get("phone").toString()
        val postalCode = requireArguments().get("postal_code").toString()
        val price = requireArguments().get("price").toString()
        val reserveUrl = requireArguments().get("reserve_url").toString()
        val state = requireArguments().get("state").toString()

        myView.apply{
            details_name.text = name
            details_address.text = address
            details_area.text = area
            details_city.text = city
            details_country.text = country
            details_ID.text = id
            details_lat.text = lat
            details_lng.text = lng
            details_mobileReserveIUrl.text = mobilReserveUrl
            details_phone.text = phone
            details_postalCode.text = postalCode
            details_price.text = price
            details_reserveUrl.text = reserveUrl
            details_state.text = state
        }
        Glide.with(requireContext())
            .load(imageUrl)
            .apply(RequestOptions().centerCrop())
            .into(imageView).view

        return myView
    }


}