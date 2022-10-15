package com.hilguener.gotcharacters.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class Char(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("firstName") val firstName: String,
    @Expose @SerializedName("lastName") val lastName: String,
    @Expose @SerializedName("fullName") val fullName: String,
    @Expose @SerializedName ("title") val title: String,
    @Expose @SerializedName ("family") val family: String,
    @Expose @SerializedName("image") val image: String,
    @Expose @SerializedName ("imageUrl") val imageUrl: String
)



