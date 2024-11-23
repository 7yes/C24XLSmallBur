package com.jesse.c24xlsmallbur.data

import com.jesse.c24xlsmallbur.data.model.SmallResponse
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface SmallApi {

    @GET("characters")
    suspend fun getData(): Response<List<SmallResponseItem>>

}