package com.alipadidar.streamx.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alipadidar.streamx.ui.screens.watch.WatchStreamScreen
import com.alipadidar.streamx.ui.screens.broadcast.BroadcastSetupScreen
import com.alipadidar.streamx.ui.theme.*

private data class TabItem(val label: String, val filled: ImageVector, val outline: ImageVector)

private val tabs = listOf(
    TabItem("خانه", Icons.Filled.Home, Icons.Outlined.Home),
    TabItem("پخش زنده", Icons.Filled.AddCircle, Icons.Outlined.AddCircleOutline),
    TabItem("پروفایل", Icons.Filled.Person, Icons.Outlined.Person)
)

@Composable
fun MainScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize().background(DarkBackground)) {
        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedTab) {
                0 -> WatchStreamScreen()
                1 -> BroadcastSetupScreen()
                2 -> ProfilePlaceholder()
            }
        }

        // Floating glass tab-bar, iOS style — pill shaped, hugging the bottom safe area
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp, vertical = 18.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(SurfaceGlassStrong)
                .padding(horizontal = 10.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, tab ->
                val selected = selectedTab == index
                val interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(RoundedCornerShape(22.dp))
                        .then(
                            if (selected) Modifier.background(BrandGradient) else Modifier
                        )
                        .clickable(interactionSource = interactionSource, indication = null) { selectedTab = index }
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Icon(
                        imageVector = if (selected) tab.filled else tab.outline,
                        contentDescription = tab.label,
                        tint = if (selected) Color.White else TextSecondary,
                        modifier = Modifier.size(22.dp)
                    )
                    if (selected) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(tab.label, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfilePlaceholder() {
    Box(modifier = Modifier.fillMaxSize().background(BackgroundGradient), contentAlignment = Alignment.Center) {
        Text("پروفایل به‌زودی...", color = TextSecondary, fontSize = 14.sp)
    }
}
