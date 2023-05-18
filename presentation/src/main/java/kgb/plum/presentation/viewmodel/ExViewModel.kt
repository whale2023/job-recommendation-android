package kgb.plum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.ExModel
import kgb.plum.domain.usecase.ExUseCase
import javax.inject.Inject

@HiltViewModel
class ExViewModel @Inject constructor(private val exUseCase: ExUseCase): ViewModel() {

    fun getUserInfo() : ExModel{
        return exUseCase.getUserInfo()
    }
}