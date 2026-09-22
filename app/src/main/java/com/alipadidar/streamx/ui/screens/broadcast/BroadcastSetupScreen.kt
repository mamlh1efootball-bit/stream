package com.alipadidar.streamx.ui.screens.broadcast

import android.Manifest
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.DesktopWindows
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.*
import com.alipadidar.streamx.ui.components.GlassCard
import com.alipadidar.streamx.ui.components.GradientAvatar
import com.alipadidar.streamx.ui.components.GradientButton
import com.alipadidar.streamx.ui.components.StatusPill
import com.alipadidar.streamx.ui.theme.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BroadcastSetupScreen() {
    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.POST_NOTIFICATIONS
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp, vertical = 20.dp)
        ) {
            // Header
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                StatusPill(text = "متصل به شبکه لایو", color = AccentGreen)
                Spacer(modifier = Modifier.weight(1f))
                GradientAvatar(initials = "SX", size = 44.dp)
            }

            Spacer(modifier = Modifier.height(18.dp))
            Text("StreamX Live", color = TextPrimary, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
            Text("پخش زنده Real-Time", color = TextSecondary, fontSize = 13.sp)

            Spacer(modifier = Modifier.height(20.dp))

            GlassCard(modifier = Modifier.fillMaxWidth(), radius = 26.dp, padding = 22.dp) {
                Text("پخش زنده ۱۰۰٪ واقعی 🚀", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("P2P / Live Screen & Camera", color = AccentBlue, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "می‌توانید فوراً تصویر دوربین گوشی یا صفحه‌نمایش خود را با کیفیت HD استریم کنید. بازدیدکنندگان با تأخیر صفر تماشا می‌کنند.",
                    color = TextSecondary,
                    fontSize = 13.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                if (permissionsState.allPermissionsGranted) {
                    GradientButton(
                        text = "استریم صفحه‌نمایش",
                        icon = Icons.Default.DesktopWindows,
                        gradient = ScreenGradient,
                        onClick = { /* راه‌اندازی RootEncoder DisplayService برای کپچر صفحه */ }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    GradientButton(
                        text = "استریم با دوربین",
                        icon = Icons.Default.CameraAlt,
                        gradient = CameraGradient,
                        onClick = { /* راه‌اندازی CameraX + RootEncoder */ }
                    )
                } else {
                    Text(
                        "برای استریم آنلاین، دسترسی به دوربین، میکروفون و اعلان‌ها لازم است.",
                        color = TextSecondary,
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    GradientButton(
                        text = "اعطای دسترسی‌ها",
                        gradient = BrandGradient,
                        onClick = { permissionsState.launchMultiplePermissionRequest() }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("استریم‌های آنلاین واقعی در حال حاضر", color = TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                Text("۰ استریم فعال", color = AccentBlue, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.height(14.dp))

            GlassCard(modifier = Modifier.fillMaxWidth(), radius = 24.dp, padding = 28.dp) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.SatelliteAlt,
                        contentDescription = null,
                        tint = AccentBlue,
                        modifier = Modifier.size(46.dp)
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text("هنوز استریمی روشن نشده است", color = TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        "اولین نفری باشید که لایو می‌گذارد! دکمه بالا را بزنید تا تصویر شما بلافاصله برای بازدیدکنندگان نمایش داده شود.",
                        color = TextSecondary,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}
