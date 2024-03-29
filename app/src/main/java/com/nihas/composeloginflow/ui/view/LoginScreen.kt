package com.nihas.composeloginflow.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nihas.composeloginflow.R
import com.nihas.composeloginflow.ui.theme.Purple80
import kotlin.math.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ){
        //LOGO
        Icon(painter = painterResource(id = R.drawable.ic_send_24), contentDescription = "",
            modifier = Modifier
                .padding(vertical = 40.dp, horizontal = 20.dp)
                .width(40.dp)
                .height(40.dp),tint = Color.White)

        Text(text = "Hello There.",
            modifier = Modifier.padding(horizontal = 20.dp), color= Color.White,fontSize = 45.sp)

        Text(text = "Login or sign up to continue.",
            modifier = Modifier.padding(horizontal = 20.dp), color= Color.White,fontSize = 16.sp)

        //CARDVIEW
        Card(shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentHeight()) {
            Column(modifier = Modifier
                .wrapContentHeight()
                .padding(16.dp)) {
                val textState = remember { mutableStateOf(TextFieldValue()) }

                OutlinedTextField(value = textState.value, onValueChange = {
                    textState.value = it
                },modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Email id") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Purple80,
                        unfocusedBorderColor = Color.Black,
                        placeholderColor = Color.Gray,
                        textColor = Color.Black
                    ))

                OutlinedTextField(value = textState.value, onValueChange = {
                    textState.value = it
                },modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),placeholder = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Purple80,
                        unfocusedBorderColor = Color.Black,
                        placeholderColor = Color.Gray,
                        textColor = Color.Black
                    )
                )

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Forgot Password?",
                        modifier = Modifier.weight(3f), color= Color.Black,fontSize = 14.sp)

                    var buttonVisibility = remember { mutableStateOf(false) }

                    Box(modifier = Modifier.width(60.dp).height(60.dp).weight(1f),contentAlignment = Alignment.Center){
                        if(!buttonVisibility.value){
                            val gradient =
                                Brush.horizontalGradient(listOf(
                                    Color(142, 108, 252),
                                    Color(127, 193, 254)
                                ))
                            GradientButton(text = "", gradient = gradient,onClick = {
                                buttonVisibility.value = !buttonVisibility.value
                            })
                        }else {
                            CircularProgressIndicator()
                        }
                    }
                }


            }
        }

        //LOGIN/SIGNUP
        Row(verticalAlignment = Alignment.Bottom,modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(bottom = 36.dp),horizontalArrangement = Arrangement.SpaceEvenly){
            Text(text = "Login",
                modifier = Modifier.padding(horizontal = 20.dp), color= Color.White,fontSize = 16.sp)

            Divider(color = Color.White, modifier = Modifier
                .height(20.dp)
                .width(1.dp))

            Text(text = "Sign up",
                modifier = Modifier.padding(horizontal = 20.dp), color= Color.White,fontSize = 16.sp)
        }
    }
}


@Composable
fun GradientButton(
    text: String,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    IconButton(modifier = Modifier.
    then(
        Modifier
            .size(64.dp)
            .background(gradient)),
        onClick = onClick) {
        Icon(
            painterResource(id = R.drawable.ic_send_24),
            "contentDescription",
            tint = Color.White)
    }
}

//Gradient Background
fun Modifier.gradientBackground(colors: List<Color>, angle: Float) = this.then(
    Modifier.drawBehind {
        val angleRad = angle / 180f * PI
        val x = cos(angleRad).toFloat() //Fractional x
        val y = sin(angleRad).toFloat() //Fractional y

        val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
        val offset = center + Offset(x * radius, y * radius)

        val exactOffset = Offset(
            x = min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - min(offset.y.coerceAtLeast(0f), size.height)
        )

        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ),
            size = size
        )
    }
)