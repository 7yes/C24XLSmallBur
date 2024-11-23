package com.jesse.c24xlsmallbur.domain

import com.jesse.c24xlsmallbur.data.SmallRepo
import com.jesse.c24xlsmallbur.data.model.SmallResponse
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import javax.inject.Inject

class SmallDataUC @Inject constructor(private val smallRepo: SmallRepo) {
    suspend operator fun invoke(): List<SmallResponseItem> = smallRepo.getData()
 }

