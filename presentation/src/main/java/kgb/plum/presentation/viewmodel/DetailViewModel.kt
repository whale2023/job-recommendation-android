package kgb.plum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.usecase.RecruitUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val recruitUseCase: RecruitUseCase) : ViewModel() {
  private lateinit var _navController: NavHostController

  fun init(navController: NavHostController) {
    _navController = navController
  }

  fun onIsWishedChange(companyModel: CompanyModel) {
    recruitUseCase.changeIsWished(companyModel)
  }

  fun navigatePop() {
    _navController.navigateUp()
  }
}