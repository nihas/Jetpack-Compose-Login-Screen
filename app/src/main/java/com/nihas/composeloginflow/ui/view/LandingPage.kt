package com.nihas.composeloginflow.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nihas.composeloginflow.R


@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .gradientBackground(
                colors = listOf(
                    Color(142, 108, 252),
                    Color(127, 193, 254)
                ), angle = 345f
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.ic_send_24), contentDescription = "",modifier = Modifier.width(50.dp).height(50.dp))
    }
}