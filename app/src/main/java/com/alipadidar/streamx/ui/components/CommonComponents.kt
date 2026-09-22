package com.alipadidar.streamx.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alipadidar.streamx.ui.theme.*

/** Primary iOS-style pill button filled with a brand gradient, plus soft glow. */
@Composable
fun GradientButton(
    text: String,
    icon: ImageVector? = null,
    gradient: Brush = BrandGradient,
    modifier: Modifier = Modifier,
    height: Dp = 56.dp,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(28.dp))
            .background(if (enabled) gradient else Brush.linearGradient(listOf(SurfaceElevated, SurfaceElevated)))
            .clickable(interactionSource = interactionSource, indication = null, enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) {
                Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(text, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

/** Frosted glass card, iOS "materials" look: translucent fill + hairline border + big radius. */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    radius: Dp = 24.dp,
    padding: Dp = 20.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(radius))
            .background(SurfaceGlassStrong)
            .border(BorderStroke(1.dp, HairlineStroke), RoundedCornerShape(radius))
            .padding(padding),
        content = content
    )
}

/** Small rounded status pill, e.g. "متصل به شبکه لایو" */
@Composable
fun StatusPill(text: String, color: Color = AccentGreen, dot: Boolean = true) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(color.copy(alpha = 0.12f))
            .border(BorderStroke(1.dp, color.copy(alpha = 0.4f)), RoundedCornerShape(50))
            .padding(horizontal = 14.dp, vertical = 7.dp)
    ) {
        if (dot) {
            Box(modifier = Modifier.size(7.dp).clip(CircleShape).background(color))
            Spacer(modifier = Modifier.width(6.dp))
        }
        Text(text, color = color, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

/** Circular gradient avatar with initials, iOS app-icon style (squircle). */
@Composable
fun GradientAvatar(initials: String, size: Dp = 48.dp, gradient: Brush = BrandGradient) {
    Box(
        modifier = Modifier.size(size).clip(RoundedCornerShape(size / 3)).background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Text(initials, color = Color.White, fontWeight = FontWeight.Bold, fontSize = (size.value / 2.6).sp)
    }
}

/** A settings-style row inside a glass card, with trailing chevron. */
@Composable
fun ChevronRow(title: String, subtitle: String? = null, onClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.Medium)
            if (subtitle != null) {
                Text(subtitle, color = TextSecondary, fontSize = 12.sp)
            }
        }
        Icon(Icons.Default.ChevronRight, contentDescription = null, tint = TextTertiary)
    }
}
