package kgb.plum.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Column
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RecruitModel
import kgb.plum.presentation.viewmodel.DetailViewModel

@Composable
fun DetailScreen(companyModel: CompanyModel, navController: NavHostController) {
  val viewModel = hiltViewModel<DetailViewModel>()
  viewModel.init(navController)
  Column {
    IconButton(onClick = viewModel::navigatePop) {
      Icon(Icons.Rounded.ArrowBack, "종료 버튼")
    }
    DetailHeader(
      recruitModel = RecruitModel(
        "[${companyModel.typeOfEmployment}] ${companyModel.recruitmentType}",
        companyModel.companyName,
        listOf(companyModel.requiredEducation, companyModel.companyType),
        companyModel.addedWishlist,
      ),
      onWishChange = { viewModel.onIsWishedChange(companyModel) },
    )
    DetailBody(companyModel)
  }
}