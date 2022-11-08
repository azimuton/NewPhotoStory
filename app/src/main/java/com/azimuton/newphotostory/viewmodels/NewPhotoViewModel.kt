package com.azimuton.newphotostory.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azimuton.domain.models.Photo
import com.azimuton.domain.usecase.InsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewPhotoViewModel @Inject constructor(
    private val insertUseCase: InsertUseCase) : ViewModel(){

    fun insertNewPhoto(photo : Photo){
        viewModelScope.launch(Dispatchers.IO) {
            insertUseCase.photoExecute(photo)
        }
    }
}