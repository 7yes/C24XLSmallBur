package com.jesse.c24xlsmallbur.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import com.jesse.c24xlsmallbur.domain.SmallDataUC
import com.jesse.c24xlsmallbur.presentation.uistate.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SmallViewModel @Inject constructor(private val smallDataUC: SmallDataUC) : ViewModel() {

    private val _uiState = MutableLiveData<UIState>(UIState.Loading)
    val uiState: LiveData<UIState> = _uiState

    private val _lastData = MutableLiveData<SmallResponseItem>()
    val lastData: LiveData<SmallResponseItem> = _lastData


    fun getData() {
        _uiState.postValue(UIState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val result = smallDataUC()
            _uiState.postValue(UIState.Success(result))
            Log.d("TAG", "getData: on VM $result ")
        }
    }

    fun updateDetail(item: SmallResponseItem) {
        _lastData.postValue(item)
    }

}