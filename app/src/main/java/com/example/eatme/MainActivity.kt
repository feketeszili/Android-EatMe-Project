package com.example.eatme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.eatme.userInterface.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val bottomNav: BottomNavigationView = findViewById(R.id.navigatonView)
            val navController = findNavController(R.id.NavigationHostFragment)
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.detailsFragment,
                    R.id.listFragment,
                    R.id.favouriteFragment,
                    R.id.profileFragment,
                    R.id.insertFragment
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            bottomNav.setupWithNavController(navController)
        //}catch (e: Exception){
         //   Log.e("EXCEPTION IN MAIN ACTIVITY", e.toString())
       // }

        val listFragment = ListFragment()
        val favouriteFragment = FavouriteFragment()
        val profileFragment = ProfileFragment()

        bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_list -> makeCurrentFragment(listFragment)
                R.id.nav_favourite -> makeCurrentFragment(favouriteFragment)
                R.id.nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }
    // I have to use this function instead of switchContent for bottomNav,
    // because the program crashes if I want to swap between fragments
    fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.NavigationHostFragment, fragment)
            commit()
        }

    }

    fun switchContent(id: Int, fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(id, fragment, fragment.toString())
        ft.addToBackStack(null)
        ft.commit()
    }
}
