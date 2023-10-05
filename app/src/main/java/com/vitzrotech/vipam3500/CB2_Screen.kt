//package com.vitzrotech.vipam3500
//
//import android.widget.Toast
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.compose.NavHost
//import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
//
//@Composable
//fun CB2_Screen(viewModel: SharedViewModel) {
//    val cb2 by remember {viewModel.cb2}
//    val cb2Clicked by remember { mutableListOf(false) }
//    val cb2Color = if (cb2 == 1u) Color(0xFF00CC00) else if (cb2 == 2u) Color(0xFFFFF0000) else Color(0xFF5A5A5A)
//
//    if (cb2Clicked) {
//        PasswordDialog("0000", onDismiss = { cb2Clicked = false }) {
//            Toast.makeText(context, "CB1 clicked", Toast.LENGTH_SHORT).show()
//        }
//    }
//    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(
//                top = it.calculateTopPadding(),
//                bottom = it.calculateBottomPadding()
//            )
//            .background(MaterialTheme.colorScheme.background)
//            .wrapContentSize(Alignment.Center),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        NavHost(
//            navController,
//            startDestination = NavRoutes.MainRoute.name
//        ) {
//            mainGraph(navController, viewModel)
//        }
//    }
//}
//
//@Composable
//@Preview
//fun CB2_ScreenPreview() {
//    VIPAM3500Theme {
//        CB2_Screen(viewModel())
//    }
//}