package com.example.eatme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant
import com.example.eatme.repository.Repository
import com.example.eatme.userInterface.*
import com.example.eatme.viewmodel.MainViewModel
import com.example.eatme.viewmodel.MainViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var restaurants : RequestRestaurants

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getRestaurants()
        viewModel.myResponse.observe(this, Observer{
            response -> restaurants = response
                //Log.d("Response", restaurants.address)
                //Log.d("Response", restaurants.city)
                //Log.d("Response", restaurants.name)
                Log.d("response", restaurants.toString())
        })

/*        val detailsFragment= DetailsFragment()
        val favouriteFragment = FavouriteFragment()
        val profileFragment = ProfileFragment()
        val navigationView: BottomNavigationView = findViewById(R.id.navigation_view)


        navigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                //R.id.nav_add -> makeCurrentFragment(detailsFragment)
                //R.id.nav_add ->makeCurrentRecycler(recyclerView)
                R.id.nav_favourite -> makeCurrentFragment(favouriteFragment)
                R.id.nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun makeCurrentRecycler(recyclerView: RecyclerView) {


    }

    fun makeCurrentFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view_tag, fragment)
                commit()
            }

            /*fun changeFragment(view: View){
        var fragment: Fragment

        if(view == findViewById(R.id.button)){
            fragment = DetailsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_place, fragment).commit()
        }
        if( view == findViewById(R.id.button2)){
            fragment = ProfileFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_place, fragment).commit()
        }
*/*/
        }




}

