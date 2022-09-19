package com.emma_ea.fakestore.android.screens

sealed class Screens(val route: String) {
    object Products : Screens("products")
    object Profile : Screens("profile")
    object Cart : Screens("cart")
}