package com.hilguener.gotcharacters.ui.charinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilguener.gotcharacters.model.api.Char
import com.hilguener.gotcharacters.model.api.CharactersResponseItem
import com.hilguener.gotcharacters.service.GotApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharInfoViewModel() : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://thronesapi.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: GotApiService = retrofit.create(GotApiService::class.java)


    val charInfo = MutableLiveData<CharactersResponseItem>()

    fun getCharInfo(id: Int) {
        val call = service.getCharInfo(id)

        call.enqueue(object : Callback<CharactersResponseItem> {
            override fun onResponse(call: Call<CharactersResponseItem>, response: Response<CharactersResponseItem>) {
                response.body()?.let { char ->
                    charInfo.postValue(char)
                }
            }
            override fun onFailure(call: Call<CharactersResponseItem>, t: Throwable) {
                call.cancel()
            }
        })
    }
}





