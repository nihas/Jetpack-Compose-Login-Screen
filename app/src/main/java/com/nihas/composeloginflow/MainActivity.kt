package com.nihas.composeloginflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import com.nihas.composeloginflow.ui.view.LoginScreen
import com.nihas.composeloginflow.ui.view.gradientBackground
import com.nihas.composeloginflow.ui.theme.ComposeLoginFlowTheme
import com.nihas.composeloginflow.ui.view.LandingPage
import com.nihas.composeloginflow.animations.newSplashTransition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoginFlowTheme(darkTheme = true) {
                val transition = newSplashTransition()
                Box {
                    LoginScreen(modifier = Modifier
                        .fillMaxSize()
                        .gradientBackground(
                            colors = listOf(
                                Color(142, 108, 252),
                                Color(127, 193, 254)
                            ), angle = 345f
                        ).alpha(transition.contentAlpha))
                    LandingPage(modifier = Modifier.alpha(transition.splashAlpha))
                }
            }
        }
    }
}