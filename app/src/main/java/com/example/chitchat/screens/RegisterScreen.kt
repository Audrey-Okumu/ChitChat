package com.example.chitchat.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chitchat.R
import com.example.chitchat.ui.theme.ChitChatTheme
import com.example.chitchat.ui.theme.Orange
import com.example.chitchat.ui.theme.Cream

@Composable
fun RegisterScreen(
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onBackClick, modifier = Modifier.align(Alignment.Start)) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
            }

            Text("Create Account", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Let's get you started", fontSize = 16.sp, color = Color.Gray)

            Spacer(Modifier.height(16.dp))

            Box(Modifier.size(70.dp).background(Orange, CircleShape), contentAlignment = Alignment.Center) {
                Icon(Icons.Default.PersonAdd, "Add Profile", tint = Color.White, modifier = Modifier.size(35.dp))
            }

            Spacer(Modifier.height(24.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                CustomTextField(fullName, { fullName = it }, "Full Name", Icons.Default.Person)
                CustomTextField(email, { email = it }, "Email", Icons.Default.Email)
                CustomTextField(password, { password = it }, "Password", Icons.Default.Lock, true)
                CustomTextField(confirmPassword, { confirmPassword = it }, "Confirm Password", Icons.Default.Lock, true)
            }
            Spacer(Modifier.height(16.dp))

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(agreeToTerms, { agreeToTerms = it }, colors = CheckboxDefaults.colors(Orange))
                Text("I agree to the Terms & Conditions", fontSize = 14.sp)
            }

            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(Orange),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Sign Up", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                HorizontalDivider(Modifier.weight(1f), color = Color.LightGray.copy(0.5f))
                Text(" or continue with ", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
                HorizontalDivider(Modifier.weight(1f), color = Color.LightGray.copy(0.5f))
            }

            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                SocialIcon(painterResource(R.drawable.google))
                SocialIcon(painterResource(R.drawable.facebook))
                SocialIcon(painterResource(R.drawable.apple))
            }

            Spacer(Modifier.height(20.dp))

            Row(Modifier.padding(bottom = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Already have an account? ", color = Color.Gray)
                Text("Log In", color = Orange, fontWeight = FontWeight.Bold, modifier = Modifier.clickable(onClick = onLoginClick))
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector,
    isPassword: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth().height(52.dp),
        placeholder = { Text(placeholder, color = Color.Gray, fontSize = 14.sp) },
        leadingIcon = { Icon(leadingIcon, null, Modifier.size(20.dp), Color.Gray) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Orange
        ),
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
        singleLine = true
    )
}

@Composable
fun SocialIcon(image: Painter) {
    Surface(Modifier.size(48.dp), CircleShape, Color.White, shadowElevation = 2.dp) {
        Box(contentAlignment = Alignment.Center) {
            Image(image, null, Modifier.size(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() =
    ChitChatTheme {
        RegisterScreen({}, {})
    }

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreviewDark() =
    ChitChatTheme(darkTheme = true) {
        RegisterScreen(
            {}, {})
    }
