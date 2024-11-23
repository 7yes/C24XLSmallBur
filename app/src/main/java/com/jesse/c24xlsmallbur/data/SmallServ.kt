package com.jesse.c24xlsmallbur.data

import com.jesse.c24xlsmallbur.data.model.SmallResponse
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import javax.inject.Inject

class SmallServ @Inject constructor( private val smallApi: SmallApi ){

    suspend fun getData(): List<SmallResponseItem> {
        val call = smallApi.getData()
        return call.body() ?: emptyList()
    }

}