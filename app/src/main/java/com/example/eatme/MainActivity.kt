package com.example.eatme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.eatme.userInterface.DetailsFragment
import com.example.eatme.userInterface.ProfileFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun changeFragment(view: View){
        var fragment: Fragment

        if(view == findViewById(R.id.button)){
            fragment = DetailsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_place, fragment).commit()
        }
        if( view == findViewById(R.id.button2)){
            fragment = ProfileFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_place, fragment).commit()
        }

    }


}