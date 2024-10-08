package com.example.gradienter.presentation.generalUiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.theme.themeColors
import com.example.gradienter.presentation.utils.extensions.toRId
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun <T> BottomSheet(
    sheetState: ModalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    values: Array<T>,
    valueToStringResId: (T) -> Int,
    onSelect: (T) -> Unit,
    selected: T,
    valueColors: Map<T, Color> = mapOf(),
    valuePrefix: Map<T, String> = mapOf(),
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        content = content,
        sheetContent = {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .background(themeColors.backPrimary)
                    .padding(16.dp)
            ) {
                values.forEach { enumValue ->
                    val background = if (enumValue == selected) {
                        themeColors.backSecondary
                    } else {
                        themeColors.backPrimary
                    }
                    Text(
                        color = valueColors[enumValue] ?: themeColors.labelPrimary,
                        style = MaterialTheme.typography.titleLarge,
                        text = (valuePrefix[enumValue] ?: "") +
                                stringResource(id = valueToStringResId(enumValue)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onSelect(enumValue)
                                scope.launch {
                                    sheetState.hide()
                                }
                            }
                            .background(background)
                            .padding(16.dp)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun BottomSheetPreview() {
    AppTheme(theme = MainTheme) {
        val scope = rememberCoroutineScope()
        val sheetState: ModalBottomSheetState =
            rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

        val color = Color(0xFF8044FF)

        var text by remember {
            mutableStateOf(
                "${ColorRepresentations.Representation.HEX6.name}\n" +
                        ColorRepresentations.getColorString(
                            color = color,
                            representation = ColorRepresentations.Representation.HEX6
                        )
            )
        }
        var selectedRepresentations by remember { mutableStateOf(ColorRepresentations.Representation.HEX6) }

        BottomSheet(
            sheetState = sheetState,
            values = ColorRepresentations.Representation.entries.toTypedArray(),
            valueToStringResId = { representation -> representation.toRId() },
            selected = selectedRepresentations,
            onSelect = { representation ->
                run {
                    selectedRepresentations = representation
                    text = "${representation.name}\n" +
                            ColorRepresentations.getColorString(
                                color = color,
                                representation = representation
                            )
                }
            },
            valueColors = mapOf(
                ColorRepresentations.Representation.HEX6 to themeColors.colorRed
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        scope.launch {
                            sheetState.show()
                        }
                    }
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = text
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Preview(
    heightDp = 200
)
@Composable
private fun SmallHeightBottomSheetPreview() {
    AppTheme(theme = MainTheme) {
        val scope = rememberCoroutineScope()
        val sheetState: ModalBottomSheetState =
            rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

        val color = Color(0xFF8044FF)

        var text by remember {
            mutableStateOf(
                "${ColorRepresentations.Representation.HEX6.name}\n" +
                        ColorRepresentations.getColorString(
                            color = color,
                            representation = ColorRepresentations.Representation.HEX6
                        )
            )
        }
        var selectedRepresentations by remember { mutableStateOf(ColorRepresentations.Representation.HEX6) }

        BottomSheet(
            sheetState = sheetState,
            values = ColorRepresentations.Representation.entries.toTypedArray(),
            valueToStringResId = { representation -> representation.toRId() },
            selected = selectedRepresentations,
            onSelect = { representation ->
                run {
                    selectedRepresentations = representation
                    text = "${representation.name}\n" +
                            ColorRepresentations.getColorString(
                                color = color,
                                representation = representation
                            )
                }
            },
            valueColors = mapOf(
                ColorRepresentations.Representation.HEX6 to themeColors.colorRed
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        scope.launch {
                            sheetState.show()
                        }
                    }
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = text
                    )
                }
            }
        }
    }
}
