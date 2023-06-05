package kgb.plum.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kgb.plum.presentation.ui.common.dialog.CustomDialog
import kgb.plum.presentation.ui.components.myPage.edit.CareerEditDialogBody
import kgb.plum.presentation.ui.components.myPage.edit.CareerEditDialogHeader
import kgb.plum.presentation.ui.components.myPage.edit.CertificationEditDialogBody
import kgb.plum.presentation.ui.components.myPage.edit.CertificationEditDialogHeader
import kgb.plum.presentation.ui.components.myPage.userInfo.UserInfoBody
import kgb.plum.presentation.ui.components.myPage.userInfo.UserInfoBodyListItem
import kgb.plum.presentation.ui.components.myPage.userInfo.UserInfoHeader
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.viewmodel.MyPageViewModel

@Composable
fun MyPageScreen() {
  val viewModel = hiltViewModel<MyPageViewModel>()
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    CustomDialog(
      controller = viewModel.certificationDialogController,
      header = {
        CertificationEditDialogHeader(
          textFieldController = viewModel.certificationTextFieldController
        )
      },
      body = {
        CertificationEditDialogBody(
          certificationList = viewModel.certificationList,
          onAddButtonClicked = { value -> viewModel.addCertification(value) })
      },
    )
    CustomDialog(
      controller = viewModel.careerDialogController,
      header = {
        CareerEditDialogHeader(
          textFieldController = viewModel.careerTextFieldController
        )
      },
      body = {
        CareerEditDialogBody(
          careerList = viewModel.careerList,
          onAddButtonClicked = { value -> viewModel.addCareer(value) }
        )
      },
    )
    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
      IconButton(onClick = viewModel::editUserInfo) {
        Icon(Icons.Rounded.Edit, "Edit Icon")
      }
    }
    UserInfoHeader(
      name = viewModel.userInfoModel.userName,
      description = "${viewModel.resumeModel.major} 전공으로 연봉 ${viewModel.resumeModel.preferIncome}정도의 ${viewModel.resumeModel.workType}을 희망합니다.",
      modifier = Modifier.padding(Padding.large)
    )
    Spacer(modifier = Modifier.height(Padding.xlarge))
    UserInfoBody(
      disabilityType = viewModel.userInfoModel.disabilityType,
      address = viewModel.userInfoModel.addressInfo,
      email = viewModel.userInfoModel.email,
      phoneNumber = "010 2630 4097",
      modifier = Modifier
        .background(Color.White)
        .padding(Padding.large)
    )
    Spacer(modifier = Modifier.height(Padding.small))
    UserInfoBodyListItem(
      title = "보유 자격증",
      leading = Icons.Rounded.Bookmark,
      valueList = viewModel.resumeModel.certifications,
      onAddButtonClicked = { viewModel.certificationDialogController.show(viewModel::initCertificationList) },
      onRemoveButtonClicked = viewModel::removeCertification,
      modifier = Modifier
        .background(Color.White)
        .padding(Padding.large)
    )
    Spacer(modifier = Modifier.height(Padding.small))
    UserInfoBodyListItem(
      title = "경력",
      leading = Icons.Rounded.Bookmark,
      valueList = viewModel.resumeModel.careers.map { careerModel -> "${careerModel.category} ${careerModel.period}년" },
      onAddButtonClicked = { viewModel.careerDialogController.show(viewModel::initCareerList) },
      onRemoveButtonClicked = viewModel::removeCareer,
      modifier = Modifier
        .clip(shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp))
        .background(Color.White)
        .padding(Padding.large)
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyPageScreenPreview() {
  WhaleTheme {
    Scaffold {
      it
      MyPageScreen()
    }
  }
}