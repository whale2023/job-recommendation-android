package kgb.plum.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import kgb.plum.presentation.ui.common.TagItem
import kgb.plum.presentation.ui.common.textField.CustomTextField
import kgb.plum.presentation.ui.components.recruit.DetailScreen
import kgb.plum.presentation.ui.components.recruit.RecruitHeader
import kgb.plum.presentation.ui.components.recruit.RecruitListItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.util.isAtBottom
import kgb.plum.presentation.util.showToast
import kgb.plum.presentation.viewmodel.RecruitViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun RecruitScreen() {
  val viewModel = hiltViewModel<RecruitViewModel>()
  val navController = rememberNavController()
  viewModel.init(navController)

  val recruitState by viewModel.recruitState.collectAsStateWithLifecycle()

  val recruitListState = rememberLazyListState()
  val isAtBottom = recruitListState.isAtBottom()

  val isRefreshing by viewModel.isRefreshing.collectAsState()

  val swipeTopRefreshState = rememberPullRefreshState(
    refreshing = isRefreshing,
    onRefresh = {
      viewModel.refreshRecruitList(viewModel.sortDropdownMenuController.currentValue.toQueryString())
    })

  LaunchedEffect(isAtBottom) {
    if (isAtBottom) {
      viewModel.getRecruitList(viewModel.sortDropdownMenuController.currentValue.toQueryString())
    }
  }

  val context = LocalContext.current

  NavHost(navController = navController, startDestination = "recruit") {
    composable("recruit") {
      Surface {
        Column(modifier = Modifier.padding(10.dp)) {
          if (!viewModel.isFilterOpen) when (recruitState) {
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
          if (viewModel.isFilterOpen) CustomTextField(
            customTextFieldController = viewModel.searchTextFieldController,
            Icons.Rounded.Search
          )
          Spacer(modifier = Modifier.height(24.dp))
          FlowRow(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            viewModel.filterList.filter { viewModel.selectedFilterMap[it.toString()] ?: false }
              .forEach { it ->
                TagItem(
                  backgroundColor = MaterialTheme.colors.background,
                  tag = it.toString(),
                  modifier = Modifier.padding(Padding.small),
                  onClick = { viewModel.updateIsFilterSelect(it.toString()) }
                )
              }
          }
          Spacer(modifier = Modifier.height(Padding.xlarge))
          if (viewModel.isFilterOpen) Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(Padding.large, Padding.large, Padding.large, 0.dp)
          ) {
            FlowRow(
              horizontalArrangement = Arrangement.Center,
              modifier = Modifier.fillMaxWidth()
            ) {
              viewModel.filterList.forEach { it ->
                if (viewModel.selectedFilterMap[it.toString()] == false)
                  TagItem(
                    backgroundColor = MaterialTheme.colors.surface,
                    borderColor = MaterialTheme.colors.background,
                    tag = it.toString(),
                    modifier = Modifier.padding(Padding.small),
                    onClick = { viewModel.updateIsFilterSelect(it.toString()) }
                  )
                else TagItem(
                  backgroundColor = MaterialTheme.colors.background,
                  tag = it.toString(),
                  modifier = Modifier.padding(Padding.small),
                  onClick = { viewModel.updateIsFilterSelect(it.toString()) }
                )
              }
            }
            IconButton(onClick = viewModel::setIsFilterOpen, modifier = Modifier.height(50.dp)) {
              Icon(
                Icons.Rounded.ExpandLess,
                "Back Btn",
              )
            }
          }
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
              Box(
                Modifier
                  .pullRefresh(swipeTopRefreshState)
              ) {
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
                PullRefreshIndicator(
                  refreshing = isRefreshing,
                  state = swipeTopRefreshState,
                  modifier = Modifier.align(Alignment.TopCenter)
                )
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