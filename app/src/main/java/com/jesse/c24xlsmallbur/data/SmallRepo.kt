package com.jesse.c24xlsmallbur.data

import com.jesse.c24xlsmallbur.data.model.SmallResponse
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import javax.inject.Inject

class SmallRepo @Inject constructor(private val smallServ: SmallServ) {

    suspend fun getData(): List<SmallResponseItem> {
       return smallServ.getData()
    }
}