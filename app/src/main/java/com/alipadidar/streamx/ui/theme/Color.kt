package com.alipadidar.streamx.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// ---- Base surfaces (deep, near-black iOS "Space" tone) ----
val DarkBackground = Color(0xFF060608)
val BgGradientTop = Color(0xFF121218)
val BgGradientBottom = Color(0xFF06060A)
val DarkSurface = Color(0xFF15151C)
val SurfaceElevated = Color(0xFF1C1C25)
val SurfaceGlass = Color(0x662A2A38)
val SurfaceGlassStrong = Color(0xB3161620)
val HairlineStroke = Color(0x1FFFFFFF)

// ---- Brand gradients (iOS-vivid: blue -> violet -> magenta) ----
val GradientBlue = Color(0xFF0A84FF)
val GradientIndigo = Color(0xFF6E5CE6)
val GradientViolet = Color(0xFF8A2BE2)
val GradientMagenta = Color(0xFFDA2DBB)
val GradientOrange = Color(0xFFFF6B35)
val GradientRed = Color(0xFFFF2E63)

// ---- Semantic accents ----
val AccentRed = Color(0xFFFF375F)
val AccentPurple = Color(0xFF8A2BE2)
val AccentBlue = Color(0xFF0A84FF)
val AccentGreen = Color(0xFF30D158)
val AccentGold = Color(0xFFFFD60A)

// ---- Text ----
val TextPrimary = Color(0xFFF5F5F7)
val TextSecondary = Color(0xFF9B9BA5)
val TextTertiary = Color(0xFF6C6C76)

// ---- Reusable brushes ----
val BrandGradient = Brush.linearGradient(listOf(GradientBlue, GradientIndigo, GradientViolet))
val LiveGradient = Brush.linearGradient(listOf(GradientRed, GradientOrange))
val ScreenGradient = Brush.linearGradient(listOf(GradientIndigo, GradientBlue))
val CameraGradient = Brush.linearGradient(listOf(Color(0xFFFF3B5C), Color(0xFFFF6B35)))
val BackgroundGradient = Brush.verticalGradient(listOf(BgGradientTop, BgGradientBottom))
val GoldGradient = Brush.horizontalGradient(listOf(Color(0xFF00C0FF), AccentGold))