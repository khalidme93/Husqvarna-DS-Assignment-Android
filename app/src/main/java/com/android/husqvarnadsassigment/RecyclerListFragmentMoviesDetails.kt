package com.android.husqvarnadsassigment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.husqvarnadsassigment.adapter.RecyclerViewMoviesDetailsAdapter
import com.android.husqvarnadsassigment.models.MovieDetailsRecyclerData
import com.android.husqvarnadsassigment.viewmodel.MovieDetailsViewModel
import com.khalidelkilany.husqvarnadsassigment.R



class RecyclerListFragmentMoviesDetails : Fragment() {


    private lateinit var recyclerAdapter : RecyclerViewMoviesDetailsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recycler_list, container, false)


        initViewModel(view)
        initViewModel()

        return view

    }

    private fun initViewModel(view: View) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion  = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)

        recyclerAdapter = RecyclerViewMoviesDetailsAdapter()
        recyclerView.adapter = recyclerAdapter


    }


    private fun initViewModel() {


        val viewModel  = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(this, Observer<MovieDetailsRecyclerData> {
            if(it != null) {
                recyclerAdapter.setUpdatedData(it)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        var id = arguments?.getInt("id")!!
        Log.d("id5656",id.toString())
        viewModel.makeApiCall(id)
    }


    companion object {

        @JvmStatic
        fun newInstance() =
                RecyclerListFragmentMoviesDetails()
    }
}



