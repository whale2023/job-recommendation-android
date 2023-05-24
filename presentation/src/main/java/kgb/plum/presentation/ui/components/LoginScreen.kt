package kgb.plum.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kgb.plum.domain.model.state.LoginState
import kgb.plum.presentation.R
import kgb.plum.presentation.model.Screen
import kgb.plum.presentation.util.showToast
import kgb.plum.presentation.viewmodel.LoginViewModel
import kumoh.whale.whale.ui.theme.Shapes
import kumoh.whale.whale.ui.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController : NavHostController){
    val context = LocalContext.current
    val loginViewModel = hiltViewModel<LoginViewModel>()
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
            Button(
                onClick = {
                    val state = loginViewModel.login()
                    showToast(context, state.state())
                    if(state == LoginState.SUCCESS){
                        navController.navigate(Screen.Main.name){
                            popUpTo(Screen.Login.name) { inclusive = true }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.primary),
                shape = Shapes.medium
            ) {
                Text(text = stringResource(id = R.string.sign_in_with_email))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.08f))
            Text(
                text = stringResource(id = R.string.sign_up),
                fontSize = 20.sp,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                color = Color.Gray,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignUp.name)
                }
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        }
    }
}
