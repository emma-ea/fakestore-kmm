package com.emma_ea.fakestore.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emma_ea.fakestore.android.screens.CartScreen
import com.emma_ea.fakestore.android.screens.ProductsScreen
import com.emma_ea.fakestore.android.screens.ProfileScreen
import com.emma_ea.fakestore.android.screens.Screens

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screens.Products.route
    ) {

        composable(
            route = Screens.Products.route,
            content = { ProductsScreen() }
        )

        composable(
            route = Screens.Cart.route,
            content = { CartScreen() }
        )

        composable(
            route = Screens.Profile.route,
            content = { ProfileScreen() }
        )
    }
}