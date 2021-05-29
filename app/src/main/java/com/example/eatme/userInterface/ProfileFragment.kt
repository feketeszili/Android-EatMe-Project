package com.example.eatme.userInterface

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eatme.MainActivity
import com.example.eatme.R


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)

        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        val insertButton: Button = view.findViewById(R.id.button)
        val imageButton: Button = view.findViewById(R.id.button2)

        val profiledata = view.findViewById<TextView>(R.id.textView2)

        var db = context?.let { DataBaseHandler(context = it) }



        val mainActivity = MainActivity()
        val insertFragment = InsertFragment()

        insertButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_insertFragment)
        //mainActivity.makeInsertFragment()
           //mainActivity.makeCurrentFragment(insertFragment)

        }

        var data = db?.readData()
        profiledata.text = ""
        if (data != null) {
            for (i in 0 until data.size) {
                profiledata.append(
                    "\n Name: " + data[i].userName + "\n Email" + data[i].email +
                            "\n Phone: " + data[i].phone + "\n Age: " + data[i].age + "\n Address: " + data[i].address
                )
            }
        }
        if (profiledata.text == "")
            profiledata.append("There is no data. Please enter your details")

        imageButton.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK)
            gallery.type = "image/*"
            startActivityForResult(gallery, 100)
        }
    return view
    }
}






