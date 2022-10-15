package com.hilguener.gotcharacters.ui.charlist


import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilguener.gotcharacters.model.api.CharResult
import com.hilguener.gotcharacters.model.api.CharactersResponse
import com.hilguener.gotcharacters.model.api.CharactersResponseItem
import com.hilguener.gotcharacters.model.api.GotApiResponse
import com.hilguener.gotcharacters.service.GotApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharListViewModel() : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://thronesapi.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: GotApiService = retrofit.create(GotApiService::class.java)

    val charList = MutableLiveData<List<CharactersResponseItem>>()

    fun getCharList(){
        val call = service.getCharList()
        call.enqueue(object: Callback<CharactersResponse>{
            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                response.body()?.let { list ->
                    charList.postValue(list)}
            }
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                call.cancel()

                Log.i("yyy", "erro ao carregar lista ${t.message}")
            }
        })
    }
}