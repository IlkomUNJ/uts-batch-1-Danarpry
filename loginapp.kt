package com.example.miapigos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginApp(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var harduser = "admin"
    var hardpass = "12345"
    var isLoggedIn by remember { mutableStateOf(false) }

    if (isLoggedIn) {
        DashboardApp()
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppNavbar(title = "Login", onBack = onBack)

            Spacer(modifier = Modifier.height(200.dp))

            Box(
                modifier = Modifier
                    .border(1.dp, Color(0xFFFFA500), RectangleShape)
                    .background(Color.White)
                    .padding(8.dp)
                    .width(250.dp)
            ) {
                if (username.isEmpty()) {
                    Text("Username", color = Color.Gray)
                }
                BasicTextField(
                    value = username,
                    onValueChange = { username = it },
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(color = Color.Black),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .border(1.dp, Color(0xFFFFA500), RectangleShape)
                    .background(Color.White)
                    .padding(8.dp)
                    .width(250.dp)
            ) {
                if (password.isEmpty()) {
                    Text("Password", color = Color.Gray)
                }
                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(color = Color.Black),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            ElevatedButton(
                onClick = {
                    if (username == harduser && password == hardpass) {
                        isLoggedIn = true
                    }
                },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color(0xFFFFA500)
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .width(150.dp)
                    .height(48.dp)
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}