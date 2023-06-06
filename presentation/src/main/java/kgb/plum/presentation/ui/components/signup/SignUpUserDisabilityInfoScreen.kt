package kgb.plum.presentation.ui.components.signup

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kgb.plum.domain.model.disabilityLevel
import kgb.plum.presentation.ui.common.buttons.PrimaryButton
import kgb.plum.presentation.viewmodel.SignUpViewModel
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.domain.model.disabilityType
import kgb.plum.domain.model.state.SignUpState
import kgb.plum.presentation.model.Screen
import kgb.plum.presentation.util.showToast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpUserDisabilityInfoScreen(navController: NavHostController, viewModel: SignUpViewModel){
    val context = LocalContext.current
    var expandedType by remember { mutableStateOf(false)}
    var selectedTypeItem by remember { mutableStateOf(disabilityType[0])}
    var expandedLevel by remember { mutableStateOf(false)}
    var selectedLevelItem by remember { mutableStateOf(disabilityLevel[0])}
    var buttonText by remember { mutableStateOf("회원가입") }
    val signUpState by viewModel.signUpState.collectAsStateWithLifecycle()
    when(signUpState) {
        is SignUpState.Loading -> {
        }
        is SignUpState.None -> {
            buttonText = "회원가입"
        }
        is SignUpState.Main -> {
            when((signUpState as SignUpState.Main).code) {
                200 -> {
                    showToast(context, "회원 가입 완료!! 환영합니다.")
                    navController.navigate(Screen.Login.name) {
                        popUpTo(Screen.SignUp.name) {
                            inclusive = true
                            saveState = false
                        }
                    }
                }
                400 -> {
                    showToast(context, "이미 가입된 정보입니다.")
                    viewModel.resetState()
                }
                404 -> {
                    showToast(context, "서버 오류. 잠시 후 다시 시도해주세요.")
                    viewModel.resetState()
                }
            }
        }
        is SignUpState.Failed -> {
            showToast(context, (signUpState as SignUpState.Failed).reason)
            viewModel.resetState()
        }
    }
    Column(
        modifier = Modifier.padding(Padding.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "사용자의 장애정보를\n 입력해주세요.",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(24.dp))
        Box(
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedType,
                onExpandedChange = {
                    expandedType = !expandedType
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = selectedTypeItem,
                    onValueChange = {
                        viewModel.setDisabilityType(it)
                    },
                    readOnly = true,
                    label = { Text(text = "장애유형")},
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedType)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(unfocusedTextColor = MaterialTheme.colors.onSurface, focusedTextColor = MaterialTheme.colors.onSurface, focusedContainerColor = MaterialTheme.colors.surface, unfocusedContainerColor = MaterialTheme.colors.surface, unfocusedLabelColor = MaterialTheme.colors.primary, focusedLabelColor = MaterialTheme.colors.background, focusedIndicatorColor = MaterialTheme.colors.surface, unfocusedIndicatorColor = MaterialTheme.colors.surface),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colors.primary,
                            shape = MaterialTheme.shapes.small
                        )
                )
                ExposedDropdownMenu(
                    expanded = expandedType,
                    onDismissRequest = { expandedType = false },
                ) {
                    disabilityType.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedTypeItem = item
                                expandedType = false
                            },
                            text = { Text( text = item)}
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        Box(
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedLevel,
                onExpandedChange = {
                    expandedLevel = !expandedLevel
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.primary,
                        shape = MaterialTheme.shapes.small
                    )
            ) {
                TextField(
                    value = selectedLevelItem,
                    onValueChange = {
                        viewModel.setDisabilityLevel(it)
                    },
                    readOnly = true,
                    label = { Text(text = "장애등급")},
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedLevel)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(unfocusedTextColor = MaterialTheme.colors.onSurface, focusedTextColor = MaterialTheme.colors.onSurface, focusedContainerColor = MaterialTheme.colors.surface, unfocusedContainerColor = MaterialTheme.colors.surface, unfocusedLabelColor = MaterialTheme.colors.primary, focusedLabelColor = MaterialTheme.colors.background, focusedIndicatorColor = MaterialTheme.colors.surface, unfocusedIndicatorColor = MaterialTheme.colors.surface),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expandedLevel,
                    onDismissRequest = { expandedLevel = false },
                ) {
                    disabilityLevel.forEach { disabilityLevel ->
                        DropdownMenuItem(
                            onClick = {
                                selectedLevelItem = disabilityLevel
                                expandedLevel = false
                            },
                            text = { Text( text = disabilityLevel)}
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        PrimaryButton (
            text = buttonText,
            onClick = {
                buttonText = "회원가입 진행중..."
                viewModel.signUp()
            },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.9f)
        )
    }
}

@Preview
@Composable
fun SignUpUserDisabilityInfoScreenPreview(){
    WhaleTheme {
        SignUpUserDisabilityInfoScreen(navController = rememberNavController(), viewModel = viewModel())
    }
}