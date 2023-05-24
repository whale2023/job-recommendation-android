package kgb.plum.presentation.ui.components.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import kgb.plum.presentation.R
import kgb.plum.presentation.model.SignUpScreen
import kgb.plum.presentation.ui.common.buttons.PrimaryButton
import kgb.plum.presentation.viewmodel.SignUpViewModel
import kumoh.whale.whale.ui.theme.Padding
import kumoh.whale.whale.ui.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpUserBasicInfoScreen(navController: NavHostController, viewModel: SignUpViewModel){
    Column(
        modifier = Modifier.padding(Padding.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "사용자의 기본 정보를\n입력해주세요.",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = viewModel.name.observeAsState(initial = "").value,
            onValueChange = { name ->
                viewModel.setName(name)
            },
            label = { Text("이름") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = viewModel.age.observeAsState(initial = "").value,
            onValueChange = { age ->
                viewModel.setAge(age)
            },
            label = { Text("나이") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Spacer(modifier = Modifier.size(24.dp))
        PrimaryButton (
            text = "다음",
            onClick = {
                navController.navigate(SignUpScreen.EmailInfo.name)
            },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.9f)
        , state = !(viewModel.age.observeAsState().value.isNullOrEmpty() || viewModel.age.observeAsState().value.isNullOrEmpty())
        )
    }
}