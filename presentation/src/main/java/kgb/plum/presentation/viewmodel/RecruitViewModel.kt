package kgb.plum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.usecase.RecruitUseCase
import kgb.plum.presentation.model.SortType
import kgb.plum.presentation.ui.common.CustomDropdownMenuController
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(private val recruitUseCase: RecruitUseCase) :
  ViewModel() {
  private lateinit var _navController: NavHostController

  fun init(navController: NavHostController) {
    this._navController = navController
  }

  val recruitList: List<CompanyModel>
    get() = recruitUseCase.getRecruitList()

  val sortDropdownMenuController = CustomDropdownMenuController(
    SortType.NEWEST,
    SortType.values().toList(),
  )

  val filterDropdownMenuController = CustomDropdownMenuController(
    "필터",
    listOf("필터"),
    onClick = { _navController.navigate("filter") }
  )

  fun onIsWishedChange(companyModel: CompanyModel) {
    recruitUseCase.changeIsWished(companyModel)
  }

  fun showDetail(companyModel: CompanyModel) {
    _navController.navigate("detail")
  }
}
