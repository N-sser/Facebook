package me.veramaximiliano.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.veramaximiliano.facebook.ui.screen.FacebookLoginScreen
import me.veramaximiliano.facebook.ui.screen.FacebookRegisterScreen
import me.veramaximiliano.facebook.ui.screen.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()
            NavHost(
                navController = myNavController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize(),
            ) {
                composable(route = "login") {
                    FacebookLoginScreen(
                        onClickRegister = {
                            myNavController.navigate(
                                "register"
                            )
                        },
                        onClickSignIn = {
                            myNavController.navigate("feed")
                        }
                    )
                }
                composable(route = "register") {
                    FacebookRegisterScreen(onClickBack = {
                        myNavController.popBackStack()
                    })
                }
                composable(route = "feed") {
                    FeedScreen()
                }

            }

        }
    }
}