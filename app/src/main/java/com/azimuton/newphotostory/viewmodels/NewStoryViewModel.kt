package com.azimuton.newphotostory.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azimuton.domain.models.Photo
import com.azimuton.domain.usecase.DeleteUseCase
import com.azimuton.domain.usecase.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewStoryViewModel @Inject constructor(
    private var getAllUseCase: GetAllUseCase,
    private var deleteUseCase: DeleteUseCase
) : ViewModel() {

//     fun getAllPhoto(){
//        viewModelScope.launch(Dispatchers.IO) {
//             getAllUseCase.photoExecute()
//        }
//    }
     fun deletePhoto(photo : Photo){
        viewModelScope.launch(Dispatchers.IO) {
            deleteUseCase.photoExecute(photo)
        }
    }
}