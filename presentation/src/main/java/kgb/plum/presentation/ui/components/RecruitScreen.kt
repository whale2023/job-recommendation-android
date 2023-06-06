package kgb.plum.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RecruitModel
import kgb.plum.presentation.ui.components.recruit.DetailScreen
import kgb.plum.presentation.ui.components.recruit.FilterScreen
import kgb.plum.presentation.ui.components.recruit.RecruitHeader
import kgb.plum.presentation.ui.components.recruit.RecruitListItem
import kgb.plum.presentation.viewmodel.RecruitViewModel

@Composable
fun RecruitScreen() {
  val viewModel = hiltViewModel<RecruitViewModel>()
  val navController = rememberNavController()
  viewModel.init(navController)

  NavHost(navController = navController, startDestination = "recruit") {
    composable("recruit") {
      Surface {
        Column(modifier = Modifier.padding(10.dp)) {
          RecruitHeader(
            viewModel.recruitList.size,
            viewModel.sortDropdownMenuController,
            viewModel.filterDropdownMenuController
          )
          Spacer(modifier = Modifier.height(24.dp))
          LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
          ) {
            items(items = viewModel.recruitList) {
              RecruitListItem(
                recruitModel = RecruitModel(
                  "[${it.typeOfEmployment}] ${it.recruitmentType}",
                  it.companyName,
                  listOf(it.requiredEducation, it.companyType),
                  it.addedWishlist,
                ),
                onWishChange = { viewModel.onIsWishedChange(it) },
                modifier = Modifier.clickable { viewModel.showDetail(it) })
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