package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.state.MyPageState
import kgb.plum.domain.model.state.RecruitState
import kgb.plum.domain.usecase.RecruitUseCase
import kgb.plum.presentation.model.SortType
import kgb.plum.presentation.ui.common.dropdown.CustomDropdownMenuController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(private val recruitUseCase: RecruitUseCase) :
  ViewModel() {
  private lateinit var _navController: NavHostController

  private var page by mutableStateOf(0)

  private val _recruitState: MutableStateFlow<RecruitState> = MutableStateFlow(RecruitState.Loading)
  val recruitState: StateFlow<RecruitState> = _recruitState

  init {
    getRecruitList()
  }

  fun init(navController: NavHostController) {
    this._navController = navController
  }

  fun refreshRecruitList() {
    page = 0
    viewModelScope.launch {
      addRecruitList(recruitUseCase.getRecruitList(page = page++, sort = "desc"))
    }
  }

  fun getRecruitList() {
    viewModelScope.launch {
      addRecruitList(recruitUseCase.getRecruitList(page = page++, sort = "desc"))
    }
  }

  private fun addRecruitList(result: EntityWrapper<List<CompanyModel>>) {
    when (result) {
      is EntityWrapper.Success -> {
        if(page == 1) {
          _recruitState.value = RecruitState.Main(
            result.entity
          )
        } else {
          val newRecruitList =
            if (_recruitState.value is RecruitState.Main) (_recruitState.value as RecruitState.Main).recruitList.toMutableList() else mutableListOf()
          newRecruitList.addAll(result.entity)
          _recruitState.value = RecruitState.Main(
            newRecruitList
          )
        }
      }

      is EntityWrapper.Fail -> {
        RecruitState.Failed(
          reason = result.error.message ?: "Unknown error"
        )
      }
    }
  }

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
    viewModelScope.launch {
      recruitUseCase.changeIsWished(companyModel.id, companyModel.addedWishlist)
      companyModel.addedWishlist = !companyModel.addedWishlist
    }
  }

  fun showDetail(companyModel: CompanyModel) {
    _navController.currentBackStackEntry?.savedStateHandle?.set(
      key = "companyModel",
      value = companyModel
    )
    _navController.navigate("detail")
  }

  fun resetRecruitState() {
    _recruitState.value = RecruitState.Loading
  }
}
