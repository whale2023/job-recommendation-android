package kgb.plum.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RecruitModel
import kgb.plum.domain.model.state.RecruitState
import kgb.plum.presentation.ui.components.recruit.DetailScreen
import kgb.plum.presentation.ui.components.recruit.FilterScreen
import kgb.plum.presentation.ui.components.recruit.RecruitHeader
import kgb.plum.presentation.ui.components.recruit.RecruitListItem
import kgb.plum.presentation.util.isAtBottom
import kgb.plum.presentation.util.isAtTop
import kgb.plum.presentation.util.showToast
import kgb.plum.presentation.viewmodel.RecruitViewModel

@Composable
fun RecruitScreen() {
  val viewModel = hiltViewModel<RecruitViewModel>()
  val navController = rememberNavController()
  viewModel.init(navController)

  val recruitState by viewModel.recruitState.collectAsStateWithLifecycle()

  val recruitListState = rememberLazyListState()
  val isAtBottom = recruitListState.isAtBottom()
  val isAtTop = recruitListState.isAtTop()
  LaunchedEffect(isAtBottom, isAtTop) {
    if(isAtBottom) {
      Log.d("RecruitScreen", "isAtBottom")
      viewModel.getRecruitList()
    }
    if(isAtTop) {
      Log.d("RecruitScreen", "isAtTop")
      viewModel.refreshRecruitList()

    }
  }

  val context = LocalContext.current

  NavHost(navController = navController, startDestination = "recruit") {
    composable("recruit") {
      Surface {
        Column(modifier = Modifier.padding(10.dp)) {
          when (recruitState) {
            is RecruitState.Main -> {
              val recruitList = (recruitState as RecruitState.Main).recruitList
              RecruitHeader(
                recruitList.size,
                viewModel.sortDropdownMenuController,
                viewModel.filterDropdownMenuController,
                viewModel::refreshRecruitList
              )
            }

            else -> {
              RecruitHeader(
                0,//recruitList.size,
                viewModel.sortDropdownMenuController,
                viewModel.filterDropdownMenuController,
                viewModel::refreshRecruitList
              )
            }
          }
          Spacer(modifier = Modifier.height(24.dp))
          when (recruitState) {
            is RecruitState.Loading -> {
              Box(
                modifier = Modifier.fillMaxSize()
              ) {
                CircularProgressIndicator(
                  modifier = Modifier.align(Alignment.Center)
                )
              }
            }

            is RecruitState.Main -> {
              val recruitList = (recruitState as RecruitState.Main).recruitList
              LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxSize(),
                state = recruitListState
              ) {
                items(items = recruitList) {
                  RecruitListItem(
                    recruitModel = RecruitModel(
                      it.id,
                      "[${it.typeOfEmployment}] ${it.recruitmentType}",
                      it.companyName,
                      listOf(it.requiredEducation, it.companyType),
                      it.addedWishlist,
                    ),
                    onWishChange = {
                      viewModel.onIsWishedChange(it)
                    },
                    modifier = Modifier.clickable { viewModel.showDetail(it) })
                }
              }
            }

            is RecruitState.Failed -> {
              showToast(context, "유저 정보를 불러올 수 없습니다. 새로 고침 해주세요.")
              viewModel.resetRecruitState()
            }
          }
        }
      }
    }
    composable("filter") {
      FilterScreen(navController)
    }
    composable("detail") {
      val companyModel =
        navController.previousBackStackEntry?.savedStateHandle?.get<CompanyModel>("companyModel")
          ?: CompanyModel(
            id = 0,
            applicationDate = "",
            recruitmentPeriod = "",
            companyName = "",
            recruitmentType = "",
            typeOfEmployment = "",
            formOfWages = "",
            wage = "",
            entryForm = "",
            requiredExperience = "",
            requiredEducation = "",
            majorField = "",
            requiredCredentials = "",
            businessAddress = "",
            companyType = "",
            responsibleAgency = "",
            contactNumber = "",
            countOfMemberWish = 0,
            registrationDate = "",
            addedWishlist = false
          )
      DetailScreen(companyModel, navController)
    }
  }
}

@Preview
@Composable
fun RecruitPreview() {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    RecruitScreen()
  }
}