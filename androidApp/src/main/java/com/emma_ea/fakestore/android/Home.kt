package com.emma_ea.fakestore.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.emma_ea.fakestore.android.BottomNavGraph
import com.emma_ea.fakestore.android.R

@Composable
fun Home(navController: NavHostController) {

    val selectedRoute = remember { mutableStateOf("products") }
    val fabShape = RoundedCornerShape(50)

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNav(selectedRoute, fabShape, navController) },
        floatingActionButton = { Fab(selectedRoute, fabShape, navController) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        BottomNavGraph(navController = navController, Modifier.padding(it))
    }
}

@Composable
fun TopBar() = TopAppBar(title = { Text(text = "FakeStore" ) })

@Composable
fun Fab(
    selectedRoute: MutableState<String>, 
    fabShape: RoundedCornerShape, 
    navController: NavController) {
    FloatingActionButton(
        backgroundColor = colorResource(id = R.color.colorPrimary) ,
        shape = fabShape,
        onClick = {
            selectedRoute.value = "cart"
            navController.navigate(Screens.Cart.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "cart icon" )
    }
}

@Composable
fun BottomNav(
    selectedRoute: MutableState<String>,
    fabShape: RoundedCornerShape,
    navController: NavController
) {
    BottomAppBar(
        cutoutShape = fabShape
    ) {

        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_products_list), contentDescription = "products icon" ) },
            label = { Text(text = "Product") },
            selected = selectedRoute.value == "products",
            alwaysShowLabel = true,
            onClick = {
                selectedRoute.value = "products"
                navController.navigate(Screens.Products.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        )

        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "profile icon" ) },
            label = { Text(text = "Profile") },
            selected = selectedRoute.value == "profile",
            alwaysShowLabel = true,
            onClick = {
                selectedRoute.value = "profile"
                navController.navigate(Screens.Profile.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        )

        //        use fab for cart
//        BottomNavigationItem(
//            icon = { Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "cart icon" ) },
//            label = { Text(text = "Cart") },
//            selected = selectedRoute.value == "cart",
//            alwaysShowLabel = true,
//            onClick = {
//                selectedRoute.value = "cart"
//                navController.navigate(Screens.Cart.route)
//            }
//        )
    }
}