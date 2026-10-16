package com.example.tugasuserinput.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.tugasuserinput.R

/**
 * Komponen untuk memilih skill menggunakan checkbox (Android, UI/UX, Web).
 */
@Composable
fun SkillCheckboxSection(
    isAndroid: Boolean,
    onAndroidChange: (Boolean) -> Unit,
    isUiUx: Boolean,
    onUiUxChange: (Boolean) -> Unit,
    isWeb: Boolean,
    onWebChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val labelSize = with(density) { dimensionResource(id = R.dimen.text_size_label).toSp() }

    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = colorResource(id = R.color.checkbox_checked),
        uncheckedColor = colorResource(id = R.color.checkbox_unchecked)
    )

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.label_choose_skill),
            color = colorResource(id = R.color.text_label),
            fontSize = labelSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_skills_to_checkboxes))
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Checkbox Android
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { onAndroidChange(!isAndroid) }
                )
            ) {
                Checkbox(
                    checked = isAndroid,
                    onCheckedChange = onAndroidChange,
                    colors = checkboxColors
                )
                Spacer(
                    modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_checkbox_to_text))
                )
                Text(
                    text = stringResource(id = R.string.skill_android),
                    color = colorResource(id = R.color.text_label),
                    fontSize = labelSize
                )
            }

            // Checkbox UI/UX
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { onUiUxChange(!isUiUx) }
                )
            ) {
                Checkbox(
                    checked = isUiUx,
                    onCheckedChange = onUiUxChange,
                    colors = checkboxColors
                )
                Spacer(
                    modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_checkbox_to_text))
                )
                Text(
                    text = stringResource(id = R.string.skill_ui_ux),
                    color = colorResource(id = R.color.text_label),
                    fontSize = labelSize
                )
            }

            // Checkbox Web
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { onWebChange(!isWeb) }
                )
            ) {
                Checkbox(
                    checked = isWeb,
                    onCheckedChange = onWebChange,
                    colors = checkboxColors
                )
                Spacer(
                    modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_checkbox_to_text))
                )
                Text(
                    text = stringResource(id = R.string.skill_web),
                    color = colorResource(id = R.color.text_label),
                    fontSize = labelSize
                )
            }
        }
    }
}
