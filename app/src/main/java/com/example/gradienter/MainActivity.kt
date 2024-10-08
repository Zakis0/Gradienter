package com.example.gradienter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gradienter.data.settings.SettingsSaveManager
import com.example.gradienter.presentation.screens.adaptiveScreen.AdaptiveScreen
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var settingsSaveManager: SettingsSaveManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        settingsSaveManager.load()

        setContent {
            AppTheme(theme = MainTheme) {
                AdaptiveScreen()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        settingsSaveManager.save()
    }
}
