package com.example.eatme.userInterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eatme.R
import com.example.eatme.repository.Repository
import com.example.eatme.viewmodel.MainViewModel
import com.example.eatme.viewmodel.MainViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


class ListFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()
    private lateinit var viewModel : MainViewModel
    private lateinit var recyclerView : RecyclerView
    private lateinit var restaurantAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val navBar: BottomNavigationView? = this.activity?.findViewById(R.id.navigatonView)
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        // set up the backend to get the data
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getRestaurants()

        // set up the RecyclerView
        recyclerView = root.findViewById(R.id.my_recycler_view)
        restaurantAdapter = MyAdapter()
        recyclerView.adapter = restaurantAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            restaurantAdapter.setData(response)
        })


        return root
    }

}