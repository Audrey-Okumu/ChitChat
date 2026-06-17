package com.example.chitchat.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chitchat.screens.LoginScreen
import com.example.chitchat.screens.RegisterScreen
import com.example.chitchat.screens.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SplashRoute,
        modifier = modifier
    ) {
        composable<SplashRoute> {
            SplashScreen(
                onLoginClick = { navController.navigate(LoginRoute) },
                onSignUpClick = { navController.navigate(RegisterRoute) }
            )
        }
        composable<LoginRoute> {
            LoginScreen(
                onBackClick = { navController.navigate(SplashRoute) },
                onSignUpClick = { navController.navigate(RegisterRoute) }
            )
        }
        composable<RegisterRoute> {
            RegisterScreen(
                onBackClick = { navController.popBackStack() },
                onLoginClick = { navController.navigate(LoginRoute) }
            )
        }
    }
}
