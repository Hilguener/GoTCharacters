package com.hilguener.gotcharacters.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GotApiResponse(
    //@Expose @SerializedName("count") val count: Int,
    //@Expose @SerializedName("next") val next: String,
    //@Expose @SerializedName("previous") val previous: String,
     val Characters: List<CharResult>
)


data class CharResult(
        @Expose @SerializedName ("id") val id: Int,
        @Expose @SerializedName("firstName") val name: String,
        @Expose @SerializedName("title") val title: String,
        @Expose @SerializedName ("imageUrl") val imageUrl: String
)