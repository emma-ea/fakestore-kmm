package com.emma_ea.fakestore.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emma_ea.fakestore.Greeting
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emma_ea.fakestore.android.screens.*
import com.google.accompanist.appcompattheme.AppCompatTheme

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCompatTheme {
                Home(rememberNavController())
            }
        }
    }
}

