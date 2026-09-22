package com.alipadidar.streamx.ui.screens.auth

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alipadidar.streamx.ui.components.GlassCard
import com.alipadidar.streamx.ui.components.GradientAvatar
import com.alipadidar.streamx.ui.components.GradientButton
import com.alipadidar.streamx.ui.theme.*

@Composable
fun AuthScreen(onLogin: () -> Unit) {
    var isRegister by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGradient)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {

            GradientAvatar(initials = "SX", size = 84.dp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("StreamX", color = TextPrimary, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
            Text("پخش زنده واقعی، بدون تاخیر", color = TextSecondary, fontSize = 13.sp)

            Spacer(modifier = Modifier.height(28.dp))

            GlassCard(modifier = Modifier.fillMaxWidth(), radius = 28.dp, padding = 24.dp) {
                AnimatedContent(targetState = isRegister, label = "authTitle") { register ->
                    Text(
                        text = if (register) "ساخت حساب استریمر" else "ورود به سیستم",
                        color = TextPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                PremiumField(
                    value = email,
                    onValueChange = { email = it },
                    label = "ایمیل",
                    leadingIcon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(14.dp))
                PremiumField(
                    value = password,
                    onValueChange = { password = it },
                    label = "رمز عبور",
                    leadingIcon = Icons.Default.Lock,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(24.dp))
                GradientButton(
                    text = if (isRegister) "ثبت‌نام" else "ورود",
                    gradient = BrandGradient,
                    onClick = onLogin
                )

                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { isRegister = !isRegister }, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = if (isRegister) "قبلاً حساب دارید؟ ورود" else "حساب نداری؟ بساز",
                        color = AccentBlue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PremiumField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: androidx.compose.ui.graphics.vector.ImageVector,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = TextSecondary) },
        leadingIcon = { Icon(leadingIcon, contentDescription = null, tint = TextSecondary) },
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = RoundedCornerShape(18.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextPrimary,
            focusedBorderColor = AccentBlue,
            unfocusedBorderColor = HairlineStroke,
            focusedContainerColor = Color(0x14FFFFFF),
            unfocusedContainerColor = Color(0x0DFFFFFF),
            cursorColor = AccentBlue
        ),
        modifier = Modifier.fillMaxWidth()
    )
}
