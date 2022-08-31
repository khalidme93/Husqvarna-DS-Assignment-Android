package com.android.husqvarnadsassigment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.husqvarnadsassigment.models.MovieDetailsRecyclerData
import com.android.husqvarnadsassigment.network.RetroInstance
import com.android.husqvarnadsassigment.network.RetroService

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel: ViewModel()    {
    var recyclerListLiveData : MutableLiveData<MovieDetailsRecyclerData>   = MutableLiveData()



    fun getRecyclerListObserver(): MutableLiveData<MovieDetailsRecyclerData>  {
        return recyclerListLiveData
    }

    fun makeApiCall(id: Int) {

        Log.d("here", id.toString())
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response  = retroInstance.getMoviesDetails(id,"d3039695d10dd6d56f9a5f0556330f8d")
            recyclerListLiveData.postValue(response)
            Log.d("TAG2", response.toString())

        }
    }
}