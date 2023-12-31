package com.vitzrotech.vipam3500

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VIPAM3500Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCompose()
                }
            }
        }
        if (!isConnected()) {
            Log.d(this.javaClass.name, "Internet connection NOT available")
            Toast.makeText(applicationContext, "Internet connection NOT available", Toast.LENGTH_LONG).show()
        }
    }

    private fun isConnected(): Boolean {
        var result = false
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = cm.getNetworkCapabilities(cm.activeNetwork)
            if (capabilities != null) {
                result = when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                    else -> false
                }
            }
        } else {
            val activeNetwork = cm.activeNetworkInfo
            if (activeNetwork != null) {
                result = when (activeNetwork.type) {
                    ConnectivityManager.TYPE_WIFI,
                    ConnectivityManager.TYPE_MOBILE,
                    ConnectivityManager.TYPE_VPN -> true
                    else -> false
                }
            }
        }
        return result
    }
}

fun NavGraphBuilder.mainGraph(navController: NavHostController, viewModel: SharedViewModel) {
    navigation(startDestination = "home", route = NavRoutes.MainRoute.name) {
        composable("home"){
            HomeScreen()
        }
        composable("voltage_current") {
            VoltageCurrentScreen(viewModel)
        }
        composable("settings") {
            SettingScreen(viewModel)
        }
        composable("relay") {
            RelayStatusScreen(viewModel)
        }
        composable("measurement") {
            MeasurementScreen(navController)
        }
        composable("system") {
            SystemScreen(navController)
        }
        composable("log") {
            LogScreen(navController)
        }
        composable("power") {
            PowerScreen(viewModel)
        }
        composable("energy") {
            EnergyScreen(viewModel)
        }
        composable("reverse Energy") {
            ReverseEnergyScreen(viewModel)
        }
        composable("DI/DO_Status") {
            //DIDO_StatusScreen(viewModel)
        }
        composable("AI_TD") {
            AI_TDScreen(viewModel)
        }
        composable("Thermal/LoadRate") {
            ThermalLoadRateScreen(viewModel)
        }
        composable("sequence") {
            SequenceScreen(viewModel)
        }
        composable("phase balance") {
            Phase_BalanceScreen(viewModel)
        }
        composable("k-factor/c-factor") {
            K_C_factorScreen(viewModel)
        }
        composable("demand") {
            DemandScreen(viewModel)
        }
        composable("max/min") {
            MaxminScreen(viewModel)
        }
        composable("true RMS") {
            True_RMS_Screen(viewModel)
        }
        composable("interlock Status") {
            Interlock_StatusScreen(viewModel)
        }
        composable("PLC_IO_Memory") {
            PLC_IO_MemoryScreen(viewModel)
        }
        composable("Simulation_Test") {
            Simulation_TestScreen(viewModel)
        }
        composable("relay Status") {
            RelayStatusBottomScreen(viewModel)
        }
        composable("oscilloscope") {
            OscilloscopeScreen(viewModel)
        }
        composable("device Info") {
            DeviceInfo_Screen(viewModel)
        }
        composable("power System") {
            PowerSystem_Screen(viewModel)
        }
        composable("addition Faculty") {
            AdditionInfo_Screen(viewModel)
        }
        composable("motor StatusInfo") {
            MotorStatusInfo_Screen(viewModel)
        }
        composable("DO Control") {
            DOcontrol_Screen(navController)
        }
        composable("breaker Failure") {
            Breaker_Screen(viewModel)
        }
        composable("TCS&TRS") {
            TCS_TRS_Screen(viewModel)
        }
        composable("coldLoad_pickUp") {
            ColdLoad_Screen(viewModel)
        }
        composable("power Supervision") {
            Supervision_Screen(viewModel)
        }
        composable("communication") {
            Communication_Screen(viewModel)
        }
        composable("VT Failure") {
            VTfailure_Screen(viewModel)
        }
        composable("virtual DI") {
            VirtualDI_Screen(navController)
        }
        composable("PQ Configuration") {
            PQconfi_Screen(viewModel)
        }
        composable("demand Configuration") {
            DemandConfi_Screen(viewModel)
        }
        composable("system Dignosis") {
            SystemDig_Screen(viewModel)
        }
        composable("Osil") {
            OscilloscopeScreen(viewModel)
        }
        composable("about") {
            AboutScreen()
        }
        composable("cb1") {
            //CB1_Screen(viewModel)
        }
        composable("cb2") {
            //CB2_Screen(viewModel)
        }
        composable("ocr") {
            OCRScreen(viewModel)
        }
        composable("ocgr") {
            OCGRScreen(viewModel)
        }
        composable("ovgr") {
            OVGRScreen(viewModel)
        }
        composable("sgr") {
            SGRScreen(viewModel)
        }
        composable("dgr") {
            DGRScreen(viewModel)
        }
        composable("ovr") {
            OVRScreen(viewModel)
        }
        composable("uvr") {
            UVRScreen(viewModel)
        }
        composable("por") {
            PORScreen(viewModel)
        }
        composable("nsovr") {
            NSOVRScreen(viewModel)
        }
        composable("docr") {
            DOCRScreen(viewModel)
        }
        composable("reclosing") {
            ReclosingScreen(viewModel)
        }
        composable("sync") {
            SyncScreen(viewModel)
        }
        composable("nsocr") {
            NSOCRScreen(viewModel)
        }
        composable("inrush") {
            InrushScreen(viewModel)
        }
        composable("ufr") {
            UFRScreen(viewModel)
        }
        composable("ofr") {
            OFRScreen(viewModel)
        }
        composable("active_power") {
            ActivePowerScreen(viewModel)
        }
        composable("reactive_power") {
            ReactivePowerScreen(viewModel)
        }
        composable("rocof") {
            ROCOFScreen(viewModel)
        }
        composable("relayMenu") {
            RelayMenuScreen(navController)
        }
    }
}

data class AppDrawerItemInfo(
    val name: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @StringRes val description: Int,
    var argument: String? = null,
)

object DrawerParams {
    val drawerItems = arrayListOf(
        AppDrawerItemInfo(
            "home",
            R.string.home,
            R.drawable.ic_home,
            R.string.home_description
        ),
        AppDrawerItemInfo(
            "measurement",
            R.string.measurement,
            R.drawable.ic_measurement,
            R.string.measurement_description
        ),
        AppDrawerItemInfo(
            "system",
            R.string.system,
            R.drawable.ic_system,
            R.string.system_description
        ),
        AppDrawerItemInfo(
            "relaymenu",
            R.string.relay,
            R.drawable.ic_relay,
            R.string.relay_description
        ),
        AppDrawerItemInfo(
            "log",
            R.string.log,
            R.drawable.ic_log,
            R.string.log_description
        ),
        AppDrawerItemInfo(
            "simulation_test",
            R.string.simulation_test,
            R.drawable.ic_simulation_test,
            R.string.simulation_test_description
        )
    )
}

enum class NavRoutes {
    MainRoute,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    val viewModel: SharedViewModel = viewModel()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    var route = currentBackStackEntry?.destination?.route.toString().substringBeforeLast("/")
    var title = ""
    val context = LocalContext.current
    DrawerParams.drawerItems.forEach{
        if (it.name == route)
            title = stringResource(it.title)
    }
    if (relayTitles.keys.contains(route)) {
        title = relayTitles[route] ?: ""
    }
    if (measurementTitles.keys.contains(route)) {
        title = measurementTitles[route] ?: ""
    }
    if (systemTitles.keys.contains(route)) {
        title = systemTitles[route] ?: ""
    }
    if (route == "settings")
        title = stringResource(R.string.settings)
    else if (route == "about")
        title = stringResource(R.string.about)
    Surface {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                val coroutineScope = rememberCoroutineScope()
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(225.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.width(225.dp),
                        ) {
                            Column {
                                Box(Modifier.clip(CircleShape)) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = "Icon",
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                        contentDescription = "Icon",
                                    )
                                }
                                Text(
                                    text = stringResource(id = R.string.app_name),
                                    color = MaterialTheme.colorScheme.onSecondary
                                )
                                Spacer(Modifier.height(12.dp))
                            }
                        }
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            items(DrawerParams.drawerItems) {
                                Surface(
                                    color = if (route == it.name)
                                        MaterialTheme.colorScheme.primary else
                                        MaterialTheme.colorScheme.background,
                                    modifier = Modifier.width(225.dp),
                                    onClick = {
                                        coroutineScope.launch {
                                            drawerState.close()
                                        }
                                        if (route != it.name) {
                                            route = it.name
                                            if (it.argument != null)
                                                route += "/" + it.argument
                                            navController.navigate(route) {
                                                popUpTo(NavRoutes.MainRoute.name)
                                            }
                                        }
                                    },
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(8.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(id = it.icon),
                                            contentDescription = stringResource(id = it.description),
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            text = stringResource(id = it.title),
                                            style = MaterialTheme.typography.bodyMedium,
                                            textAlign = TextAlign.Center,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                title,
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = MaterialTheme.typography.titleMedium,
                            )
                        },
                        navigationIcon = {
                            val coroutineScope = rememberCoroutineScope()
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    if (route == "settings" || route == "about") {
                                        navController.popBackStack()
                                    } else {
                                        drawerState.open()
                                    }
                                }
                            }) {
                                if (route == "settings" || route == "about") {
                                    Icon(
                                        Icons.Default.ArrowBack,
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        contentDescription = stringResource(id = R.string.menu_description)
                                    )
                                } else {
                                    Icon(
                                        Icons.Rounded.Menu,
                                        stringResource(id = R.string.menu_description),
                                        Modifier.size(24.dp),
                                        MaterialTheme.colorScheme.onPrimary,
                                    )
                                }
                            }
                        },
                        actions = {
                            if (route != "settings" && route != "about") {
                                IconButton(onClick = {
                                    navController.navigate("settings") {
                                        popUpTo(popUpToId)
                                    }
                                }) {
                                    Icon(
                                        painterResource(R.drawable.ic_settings),
                                        stringResource(R.string.settings_description),
                                        Modifier.size(24.dp),
                                        MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                                IconButton(onClick = {
                                    navController.navigate("about") {
                                        popUpTo(popUpToId)
                                    }
                                }) {
                                    Icon(
                                        painterResource(R.drawable.ic_info),
                                        stringResource(R.string.about_description),
                                        Modifier.size(24.dp),
                                        MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            MaterialTheme.colorScheme.primary
                        ),
                    )
                },
                bottomBar = {
                    NavigationBar() {
                        NavigationBarItem(route == "home",
                            onClick = {
                                navController.navigate("home") {
                                    popUpTo(popUpToId)
                                }
                            },
                            icon = {
                                Icon(
                                    painterResource(R.drawable.ic_home),
                                    contentDescription = stringResource(R.string.home_description),
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            label = { Text(stringResource(R.string.home)) }
                        )
                        NavigationBarItem(route == "relay",
                            onClick = {
                                navController.navigate("relay") {
                                    popUpTo(popUpToId)
                                }
                            },
                            icon = {
                                Icon(
                                    painterResource(R.drawable.ic_relay),
                                    contentDescription = stringResource(R.string.relay_description),
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            label = { Text(stringResource(R.string.relay)) }
                        )
                        NavigationBarItem(route == "cb1",
                            onClick = {
                                navController.navigate("cb1") {
                                    popUpTo(popUpToId)
                                }
                            },
                            icon = {
                                Icon(
                                    painterResource(R.drawable.ic_cb1),
                                    contentDescription = stringResource(R.string.cb1_description),
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            label = { Text(stringResource(R.string.cb1)) }
                        )
                        NavigationBarItem(route == "cb2",
                            onClick = {
                                navController.navigate("cb2") {
                                    popUpTo(popUpToId)
                                }
                            },
                            icon = {
                                Icon(
                                    painterResource(R.drawable.ic_cb2),
                                    contentDescription = stringResource(R.string.cb2_description),
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            label = { Text(stringResource(R.string.cb2)) }
                        )
                    }
                },
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = it.calculateTopPadding(),
                            bottom = it.calculateBottomPadding()
                        )
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentSize(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NavHost(
                        navController,
                        startDestination = NavRoutes.MainRoute.name
                    ) {
                        mainGraph(navController, viewModel)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainActivityPreview() {
    VIPAM3500Theme() {
        MainCompose()
    }
}
