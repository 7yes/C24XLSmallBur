package com.jesse.c24xlsmallbur.presentation.uistate

import com.jesse.c24xlsmallbur.data.model.SmallResponseItem

sealed class UIState {
        data object Loading:UIState()
        data class Error(val error:String):UIState()
        data class Success(val mySuccessList:List<SmallResponseItem>):UIState()
}
