package com.example.eatme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.eatme.userInterface.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()
        val detailsFragment = DetailsFragment()
        val favouriteFragment = FavouriteFragment()
        val profileFragment = ProfileFragment()
        val navigationView: BottomNavigationView = findViewById(R.id.navigation_view)


          navigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_list -> makeCurrentFragment(listFragment)
                R.id.nav_favourite -> makeCurrentFragment(favouriteFragment)
                R.id.nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment, fragment)
                commit()
            }

        }





}

