package kgb.plum.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kgb.plum.domain.model.state.LoginState
import kgb.plum.presentation.R
import kgb.plum.presentation.model.Screen
import kgb.plum.presentation.ui.common.buttons.PrimaryButton
import kgb.plum.presentation.ui.common.buttons.UnderlinedButton
import kgb.plum.presentation.util.showToast
import kgb.plum.presentation.viewmodel.LoginViewModel
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(context: Context, navController : NavHostController){
    val context = LocalContext.current
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val result by loginViewModel.loginState.collectAsState()
    var buttonText by remember { mutableStateOf("이메일로 로그인")}

    when(result) {
        LoginState.LOADING -> {

        }
        LoginState.ID_PW_EMPTY -> {
            showToast(context, "아이디와 비밀번호를 먼저 입력해주세요.")
            buttonText = "이메일로 로그인"
        }
        LoginState.NOT_EMAIL -> {
            showToast(context, "아이디 양식이 잘못 되었습니다.")
            buttonText = "이메일로 로그인"
        }
        LoginState.SUCCESS -> {
            loginViewModel.saveToken(context)
            navController.navigate(kgb.plum.presentation.model.Screen.Main.name){
                popUpTo(kgb.plum.presentation.model.Screen.Login.name) { inclusive = true }
            }
        }
        LoginState.WRONG_PW_ID -> {
            showToast(context, "잘못된 로그인 정보입니다.")
            buttonText = "이메일로 로그인"
        }
        LoginState.UNKNOWN_ERROR -> {
            showToast(context, "Unknown error")
            buttonText = "이메일로 로그인"
        }
    }
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Spacer(
                modifier = Modifier.fillMaxHeight(0.2f)
            )
            Image(
                modifier = Modifier.fillMaxSize(0.2f),
                painter = painterResource(id = R.drawable.baseline_cloud_72),
                contentDescription = "로고 예시"
            )
            Text(text = "로고 예시")
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                value = loginViewModel.id.observeAsState(initial = "").value,
                onValueChange = { id ->
                    loginViewModel.setId(id)
                },
                label = { Text("Email") },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(12.dp))
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
                label = { Text("PW") },
                value = loginViewModel.pw.observeAsState(initial = "").value,
                onValueChange = { pw ->
                    loginViewModel.setPw(pw)
                },
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true
            )
            Spacer(modifier = Modifier.size(20.dp))
            PrimaryButton(
                onClick = {
                    loginViewModel.login()
                    buttonText = "로그인 진행중..."
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(56.dp),
                text = buttonText
            )
            UnderlinedButton(
                text = stringResource(id = R.string.sign_up),
                modifier = Modifier.fillMaxWidth(0.7f),
                onClick = {
                    navController.navigate(Screen.SignUp.name){
                        popUpTo(Screen.Login.name) { inclusive = true }
                    }
                }
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        }
    }
}

