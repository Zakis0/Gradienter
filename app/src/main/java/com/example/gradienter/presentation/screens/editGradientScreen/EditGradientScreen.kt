package com.example.gradienter.presentation.screens.editGradientScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.presentation.generalUiElements.ContentDialog
import com.example.gradienter.presentation.screens.editGradientScreen.components.ColorPickerRGB
import com.example.gradienter.presentation.screens.editGradientScreen.components.EditGradientList
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.theme.themeColors

@Composable
fun EditGradientScreen(
    screenState: EditGradientScreenState,
    screenAction: (EditGradientScreenAction) -> Unit,
    navigateBack: () -> Unit,
) {
    var showColorPickerDialog by remember { mutableStateOf(false) }
    var сolorPickerColor by remember { mutableStateOf(Color.Black) }
    var editGradientItemId by remember { mutableStateOf("") }

    BackHandler(enabled = showColorPickerDialog) {
        showColorPickerDialog = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColors.backPrimary)
    ) {
        EditGradientList(
            modifier = Modifier
                .background(themeColors.backSecondary)
                .padding(8.dp),
            itemsList = screenState.editGradientItems,
            onAddNewElementClick = {
                screenAction(EditGradientScreenAction.OnAddNewElementClick)
            },
            onColorChangeClick = { id, color ->
                run {
                    editGradientItemId = id
                    сolorPickerColor = color
                    showColorPickerDialog = true
                }
            },
            onDistanceChange = { id, distance ->
                screenAction(
                    EditGradientScreenAction.OnChangeElementDistance(
                        editGradientItemId = id,
                        distance = distance
                    )
                )
            },
            onUpArrowClick = { editGradientItem ->
                screenAction(
                    EditGradientScreenAction.OnUpArrowClick(
                        editGradientItem = editGradientItem,
                    )
                )
            },
            onDownArrowClick = { editGradientItem ->
                screenAction(
                    EditGradientScreenAction.OnDownArrowClick(
                        editGradientItem = editGradientItem,
                    )
                )
            },
            onDeleteItem = { editGradientItem ->
                screenAction(
                    EditGradientScreenAction.OnDeleteElement(
                        editGradientItem = editGradientItem,
                    )
                )
            }
        )
        if (showColorPickerDialog) {
            ContentDialog(
                onDismiss = {
                    showColorPickerDialog = false
                }
            ) {
                ColorPickerRGB(
                    color = сolorPickerColor,
                    onColorChange = { color ->
                        screenAction(
                            EditGradientScreenAction.OnChangeElementColor(
                                editGradientItemId = editGradientItemId,
                                color = color
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun EditGradientScreenPreview() {
    AppTheme(theme = MainTheme) {
        EditGradientScreen(
            screenState = EditGradientScreenState(
                listOf(
                    EditGradientItem(color = Color.Red, distanceToNextColor = 64),
                    EditGradientItem(color = Color.Yellow, distanceToNextColor = 64),
                    EditGradientItem(color = Color.Green, distanceToNextColor = 64),
                    EditGradientItem(color = Color.Blue, distanceToNextColor = 64),
                )
            ),
            navigateBack = {},
            screenAction = {},
        )
    }
}
