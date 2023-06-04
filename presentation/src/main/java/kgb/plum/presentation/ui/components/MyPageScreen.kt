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
    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
      IconButton(onClick = { viewModel.editUserInfo() }) {
        Icon(Icons.Rounded.Edit, "Edit Icon")
      }
    }
    UserInfoHeader(
      name = viewModel.userInfoModel.userName,
      description = "구미에 거주하며 사무업 취직을 희망하고 편식을 어려워 합니다.",
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
      valueList = listOf<String>("정보 처리 기사", "정보 처리 기사", "정보 처리 기사"),
      modifier = Modifier
        .background(Color.White)
        .padding(Padding.large)
    )
    Spacer(modifier = Modifier.height(Padding.small))
    UserInfoBodyListItem(
      title = "보유 자격증",
      leading = Icons.Rounded.Bookmark,
      valueList = listOf<String>("정보 처리 기사", "정보 처리 기사", "정보 처리 기사"),
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