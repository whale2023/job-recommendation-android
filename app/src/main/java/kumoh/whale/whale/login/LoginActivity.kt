@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package kumoh.whale.whale.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kumoh.whale.whale.MainActivity
import kumoh.whale.whale.R
import kumoh.whale.whale.signup.SignUpActivity
import kumoh.whale.whale.ui.theme.Shapes
import kumoh.whale.whale.ui.theme.WhaleTheme
import kumoh.whale.whale.ui.theme.color.mainBlue
import kumoh.whale.whale.ui.theme.color.skyBlue

class LoginActivity : ComponentActivity() {

    val homeIntent = Intent(this, MainActivity::class.java)
    val signUpIntent = Intent(this, SignUpActivity::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhaleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel()
){
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
                label = {Text("Email")},
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = mainBlue, focusedBorderColor = skyBlue),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.size(12.dp))
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = mainBlue, focusedBorderColor = skyBlue),
                label = {Text("PW")},
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
                    loginViewModel.isLogin
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = mainBlue),
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

                }
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    WhaleTheme {
        LoginScreen()
    }
}