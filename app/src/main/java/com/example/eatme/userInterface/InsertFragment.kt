package com.example.eatme.userInterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.eatme.R


class InsertFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_insert, container, false)
        val view: View = inflater.inflate(R.layout.fragment_insert, container, false)

        val insertButton: Button = view.findViewById<Button>(R.id.insertButton)

        val name: EditText = view.findViewById<EditText>(R.id.name)
        val email: EditText = view.findViewById<EditText>(R.id.email)
        val phone: EditText = view.findViewById<EditText>(R.id.phone)
        val age: EditText = view.findViewById<EditText>(R.id.age)
        val address: EditText = view.findViewById<EditText>(R.id.address)

        var db = context?.let { DataBaseHandler(context = it) }

        fun insert(){
            if( name.text.toString().length > 0 &&
                    email.text.toString().length > 0 &&
                    phone.text.toString().length > 0 &&
                    age.text.toString().length > 0 &&
                    address.text.toString().length > 0){
                var profile_data =ProfileData(name.text.toString(),email.text.toString(), phone.text.toString().toInt(), age.text.toString().toInt(), address.text.toString())
                db?.insertData(profile_data)
            }
        }
        insertButton.setOnClickListener(){
            insert()
        }
        return view

    }


}