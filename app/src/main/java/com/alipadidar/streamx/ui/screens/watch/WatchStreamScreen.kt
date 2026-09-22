package com.alipadidar.streamx.ui.screens.watch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alipadidar.streamx.ui.components.GradientAvatar
import com.alipadidar.streamx.ui.theme.*

data class ChatMessage(val username: String, val message: String, val badge: String = "")

@Composable
fun WatchStreamScreen() {
    var messageText by remember { mutableStateOf("") }
    val chatMessages = listOf(
        ChatMessage("MAMAD_ME", "داش من بخاطر تو اینجام", "👑 #1"),
        ChatMessage("ioscaskayt", "سلام"),
        ChatMessage("parham463", "داداش من میخواستم برم کاستوم"),
        ChatMessage("AmirReza", "لایک بزنین بریم کاس")
    )

    Column(modifier = Modifier.fillMaxSize().background(DarkBackground)) {

        // ۱. هدر استریمر (شیشه‌ای، گرادینت)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(Brush.verticalGradient(listOf(Color(0xFF1B1B26), Color.Black)))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBackIosNew, null, tint = Color.White, modifier = Modifier.size(18.dp))
                }
                GradientAvatar(initials = "M", size = 38.dp, gradient = BrandGradient)
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text("@MORIYTT", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(AccentRed))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("زنده · ۱۹ بیننده  👍 ۱۱۰", color = TextSecondary, fontSize = 11.sp)
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(Icons.Default.MoreVert, null, tint = Color.White)
                }
            }

            // لیدربورد حامیان، پیل‌های گرادینت طلایی
            Column(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
                    .width(140.dp)
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp)
                            .height(20.dp)
                            .clip(RoundedCornerShape(50))
                            .background(GoldGradient),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            "حامی #${index + 1}",
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
            }
        }

        // ۲. تصویر پخش + لایه چت شیشه‌ای
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(Color(0xFF17171F))
        ) {
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFF23232E))) // Placeholder for ExoPlayer SurfaceView

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(SurfaceGlassStrong)
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("هدف: اینترنت خوب برای استریم", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Medium)
                Text("۱۵٪", color = AccentGold, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(0.86f)
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp, bottom = 72.dp),
                reverseLayout = true
            ) {
                items(chatMessages.reversed()) { msg ->
                    Row(
                        modifier = Modifier
                            .padding(vertical = 3.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(SurfaceGlassStrong)
                            .padding(horizontal = 12.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (msg.badge.isNotEmpty()) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(BrandGradient)
                            ) {
                                Text(msg.badge, color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text(msg.username, color = Color(0xFFFFB74D), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(msg.message, color = Color.White, fontSize = 12.sp)
                    }
                }
            }

            // نوار پیام شناور شیشه‌ای
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Brush.verticalGradient(listOf(Color.Transparent, Color(0xE60A0A10))))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = messageText, onValueChange = { messageText = it },
                    placeholder = { Text("پیام بنویس...", color = TextTertiary, fontSize = 13.sp) },
                    modifier = Modifier.weight(1f).height(50.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0x26FFFFFF),
                        unfocusedContainerColor = Color(0x1AFFFFFF),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    shape = RoundedCornerShape(26.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(onClick = {}) { Icon(Icons.Default.SentimentSatisfiedAlt, null, tint = Color.White) }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(GoldGradient),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.AttachMoney, null, tint = Color.Black, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}
