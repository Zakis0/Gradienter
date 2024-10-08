package com.example.gradienter.presentation.theme.mainTheme

import androidx.compose.ui.graphics.Color
import com.example.gradienter.presentation.theme.Theme

object MainTheme : Theme() {
    // Light
    override val lightLabelPrimary = Color(0xFF000000)
    override val lightLabelSecondary = Color(0x99000000)
    override val lightLabelTertiary = Color(0x4D000000)
    override val lightLabelDisable = Color(0x26000000)

    override val lightBackPrimary = Color(0xFFF7F6F2)
    override val lightBackSecondary = Color(0xFEAAAAA5)
    override val lightBackTertiary = Color(0x26000000)

    override val lightRed = Color(0xFFFF3B30)
    override val lightGreen = Color(0xFF34C759)
    override val lightBlue = Color(0xFF007AFF)
    override val lightGray = Color(0xFF8E8E93)
    override val lightGrayLight = Color(0xFFD1D1D6)
    override val lightWhite = Color(0xFFFFFFFF)

    // Dark
    override val darkLabelPrimary = Color(0xFFFFFFFF)
    override val darkLabelSecondary = Color(0x99FFFFFF)
    override val darkLabelTertiary = Color(0x66FFFFFF)
    override val darkLabelDisable = Color(0x26FFFFFF)

    override val darkBackPrimary = Color(0xFF161618)
    override val darkBackSecondary = Color(0xFF252528)
    override val darkBackTertiary = Color(0x66FFFFFF)

    override val darkRed = Color(0xFFFF453A)
    override val darkGreen = Color(0xFF32D74B)
    override val darkBlue = Color(0xFF0A84FF)
    override val darkGray = Color(0xFF8E8E93)
    override val darkGrayLight = Color(0xFF48484A)
    override val darkWhite = Color(0xFFFFFFFF)
}
