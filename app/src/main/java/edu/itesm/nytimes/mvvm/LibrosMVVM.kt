package edu.itesm.nytimes.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.itesm.nytimes.patterns.RetrofitSingleton
import edu.itesm.nytimes.response.NewResponse
import edu.itesm.nytimes.service.LibrosAPIService

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class LibrosMVVM: ViewModel() {
    var liveData : MutableLiveData<NewResponse> = MutableLiveData()
    fun getLiveDataObserver(): MutableLiveData<NewResponse> {
        return liveData
    }

    fun newAPICall(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitSingleton.getRetrofit().create(LibrosAPIService::class.java).getBooks()

            call.enqueue(object : Callback<NewResponse> {
                override fun onResponse(call: Call<NewResponse>, response: Response<NewResponse>) {
                    Log.v("libro", response.body()?.results?.books.toString())
                    liveData.postValue(response.body() )
                }

                override fun onFailure(call: Call<NewResponse>, t: Throwable) {
                    liveData.postValue(null)
                    Log.v("libro","no hay resultados")
                }
            })
        }
    }
}