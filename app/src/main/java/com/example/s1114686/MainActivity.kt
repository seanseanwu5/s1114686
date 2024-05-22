package com.example.s1114686

import androidx.compose.ui.Modifier
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s1114686.ui.theme.S1114686Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S1114686Theme {
                App()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBarWithMenu(navController)
        }
    ) {
        NavHost(navController, startDestination = "JumpFirst") {
            composable("JumpFirst") { FirstScreen(navController) }
            composable("JumpSecond") { SecondScreen(navController) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(navController: androidx.navigation.NavController) {
    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.maria),
                contentDescription = "App Logo",
            )
        },
        actions = {
            IconButton(
                onClick = { showMenu = true }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More")
            }
            DropdownMenu(
                expanded = showMenu, onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text("簡介") },
                    onClick = {
                        navController.navigate("JumpFirst")
                        showMenu = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("主要機構") },
                    onClick = {
                        navController.navigate("JumpSecond")
                        showMenu = false
                    }
                )
            }
        }
    )
}

@Composable
fun FirstScreen(navController: NavController) {
    var isOriginalState by remember { mutableStateOf(true) }
    AnimatedVisibility(
        visible = isOriginalState,
        enter = fadeIn(animationSpec = tween(3000)),
        exit = fadeOut(animationSpec = tween(3000))
    ) {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier.fillMaxSize().padding(top = 70.dp)) {
            Text(text = "瑪利亞基金會服務總覽", color = Color.Blue)
        }
    }
    AnimatedVisibility(
        visible = !isOriginalState,
        enter = fadeIn(animationSpec = tween(3000)),
        exit = fadeOut(animationSpec = tween(3000))
    ) {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier.fillMaxSize().padding(top = 70.dp)) {
            Text(text = "關於App作者", color = Color.Blue)
        }
    }
    AnimatedVisibility(
        visible = isOriginalState,
        enter = fadeIn(animationSpec = tween(3000)),
        exit = fadeOut(animationSpec = tween(3000))
    ) {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)) {
            Image(painter = painterResource(id = R.drawable.service), contentDescription = "瑪利亞基金會相關圖片")
        }
    }
    AnimatedVisibility(
        visible = !isOriginalState,
        enter = fadeIn(animationSpec = tween(3000)),
        exit = fadeOut(animationSpec = tween(3000))
    ) {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)) {
            Image(painter = painterResource(id = R.drawable.me), contentDescription = "這邊放自己的圖片")
        }
    }

    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(3000)),
        exit = fadeOut(animationSpec = tween(3000))
    ) {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier
            .fillMaxSize()
            .padding(top = if (isOriginalState) 400.dp else 570.dp)) {
            Button(onClick = { isOriginalState = !isOriginalState }) {
                Text(text = if (isOriginalState) "作者: 資管系吳咏壎" else "服務總覽")
            }
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp)
    ) {
        Text(
            text = "主要機構",
            color = Color.Red
        )
    }
}

//git commit -m "v3_吳咏壎"