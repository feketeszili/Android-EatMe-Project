package com.example.eatme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.eatme.userInterface.*
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        /*
        I had to use a try catch here, because I had an error
        like: Inflating Class fragment, which said the main
        fragments ID is duplicated. I found an comment on StackOverflow
        which tells what error this is.

        The initial cause of the error could be a wide variety of things,
        which is why there are so many different answers here as to what
        fixed the problem for each person. For some, it had to do with the id,
        class, or name attributes. For others it was due to a permissions
        issue or a build setting. For me, those didn't fix the problem;
        instead there was a drawable resource that existed only in
        drawable-ldrtl-xhdpi, instead of in an applicable place like drawable.

        But those are just details. The big-picture problem is that the error
        message that shows up in logcat doesn't describe the exception that
        started it all. When a higher-level layout XML references a fragment,
        the fragment's onCreateView() is called. When an exception occurs in
        a fragment's onCreateView() (for example while inflating the fragment's
        layout XML), it causes the inflation of the higher-level layout XML to fail.
        This higher-level inflation failure is what gets reported as an exception
        in the error logs. But the initial exception doesn't seem to travel
        up the chain well enough to be reported.

        Given that situation, the question is how to expose the initial
        exception, when it doesn't show up in the error log.

        The solution is pretty straightforward: Put a try/catch blockaround the
        contents of the fragment's onCreateView()
        It may not be obvious which fragment class's onCreateView() to do this to,
        in which case, do it to each fragment class that's used in the layout that caused the problem.
         */
        //try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val bottomNav: BottomNavigationView = findViewById(R.id.navigatonView)
            val navController = findNavController(R.id.NavigationHostFragment)
            val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.detailsFragment, R.id.listFragment, R.id.favouriteFragment, R.id.profileFragment, R.id.insertFragment))
            setupActionBarWithNavController(navController, appBarConfiguration)
            bottomNav.setupWithNavController(navController)
        //}catch (e: Exception){
         //   Log.e("EXCEPTION IN MAIN ACTIVITY", e.toString())
       // }

        val listFragment = ListFragment()
        val detailsFragment = DetailsFragment()
        val favouriteFragment = FavouriteFragment()
        val profileFragment = ProfileFragment()
        val insertFragment = InsertFragment()


        bottomNav.setOnNavigationItemSelectedListener{
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
            replace(R.id.NavigationHostFragment, fragment)
            commit()
        }

    }
}
