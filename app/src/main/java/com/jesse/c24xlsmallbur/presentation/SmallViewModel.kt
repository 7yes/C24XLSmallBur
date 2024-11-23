package com.jesse.c24xlsmallbur.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesse.c24xlsmallbur.domain.SmallDataUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SmallViewModel @Inject constructor( private val smallDataUC: SmallDataUC): ViewModel() {

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = smallDataUC()
            Log.d("TAG", "getData: on VM $result ")
        }
    }

}