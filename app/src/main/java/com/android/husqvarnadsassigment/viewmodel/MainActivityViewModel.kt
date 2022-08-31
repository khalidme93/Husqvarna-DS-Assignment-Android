package com.android.husqvarnadsassigment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.husqvarnadsassigment.models.MoviesRecyclerList
import com.android.husqvarnadsassigment.network.RetroInstance
import com.android.husqvarnadsassigment.network.RetroService

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel()    {
    var recyclerListLiveData : MutableLiveData<MoviesRecyclerList>   = MutableLiveData()



    fun getRecyclerListObserver(): MutableLiveData<MoviesRecyclerList>  {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response  = retroInstance.getMovies("d3039695d10dd6d56f9a5f0556330f8d")
            recyclerListLiveData.postValue(response)
        }
    }
}