package com.example.chitchat.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chitchat.R
import com.example.chitchat.ui.theme.ChitChatTheme
import com.example.chitchat.ui.theme.DarkBlue
import com.example.chitchat.ui.theme.Orange

@Composable
fun LoginScreen(
    onBackClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onBackClick, modifier = Modifier.align(Alignment.Start)) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack, 
                    "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

            Text(
                "Welcome Back", 
                fontSize = 28.sp, 
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                "Log in to continue", 
                fontSize = 16.sp, 
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )

            Spacer(Modifier.height(16.dp))

            Box(
                Modifier.size(80.dp).background(MaterialTheme.colorScheme.secondary, CircleShape), 
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Person, 
                    "Profile", 
                    tint = MaterialTheme.colorScheme.onSecondary, 
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(Modifier.height(32.dp))

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                CustomTextField(email, { email = it }, "Email", Icons.Default.Email)
                
                Column {
                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "Password",
                        leadingIcon = Icons.Default.Lock,
                        isPassword = true,
                        passwordVisible = passwordVisible,
                        onPasswordToggle = { passwordVisible = !passwordVisible }
                    )
                    Text(
                        text = "Forget Password?",
                        color = Orange,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 8.dp)
                            .clickable { /* TODO */ }
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(Orange),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Log In", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                HorizontalDivider(
                    Modifier.weight(1f), 
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f)
                )
                Text(
                    " or continue with ", 
                    fontSize = 12.sp, 
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f), 
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(
                    Modifier.weight(1f), 
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f)
                )
            }

            Spacer(Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                SocialIcon(painterResource(R.drawable.google))
                SocialIcon(painterResource(R.drawable.facebook))
                SocialIcon(painterResource(R.drawable.apple))
            }

            Spacer(Modifier.weight(1f))

            Row(modifier = Modifier.padding(bottom = 24.dp), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Don't have an account? ", 
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
                Text(
                    "Sign Up", 
                    color = MaterialTheme.colorScheme.primary, 
                    fontWeight = FontWeight.Bold, 
                    modifier = Modifier.clickable(onClick = onSignUpClick)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() = ChitChatTheme {
    LoginScreen({}, {})
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreviewDark() = ChitChatTheme(darkTheme = true) {
    LoginScreen({}, {})
}
