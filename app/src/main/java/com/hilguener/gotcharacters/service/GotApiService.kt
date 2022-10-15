package com.hilguener.gotcharacters.service

import com.hilguener.gotcharacters.model.api.Char
import com.hilguener.gotcharacters.model.api.CharactersResponse
import com.hilguener.gotcharacters.model.api.CharactersResponseItem
import com.hilguener.gotcharacters.model.api.GotApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GotApiService {
    @GET("characters/{id}")
    fun getCharInfo(@Path("id") id: Int): Call<CharactersResponseItem>
    @GET("characters")
    fun getCharList(): Call<CharactersResponse>
}