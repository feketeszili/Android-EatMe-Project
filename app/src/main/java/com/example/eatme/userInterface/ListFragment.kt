package com.example.eatme.userInterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eatme.R
import com.example.eatme.model.RequestRestaurants
import com.example.eatme.model.Restaurant
import com.example.eatme.repository.Repository
import com.example.eatme.viewmodel.MainViewModel
import com.example.eatme.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    lateinit var viewModel : MainViewModel
    lateinit var recyclerView : RecyclerView
    lateinit var list: MutableLiveData<RequestRestaurants>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // set up the backend to get the data
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getRestaurants()

        // set up the RecyclerView
        val adapter = MyAdapter()
        recyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

        list = viewModel.myResponse
        list.value?.let { adapter.setData( it.restaurants) }

        return view
    }



}