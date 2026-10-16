package com.example.tugasuserinput.ui.components

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.tugasuserinput.R
import java.util.Calendar

/**
 * Komponen baris input untuk Tanggal Lahir (dengan DatePickerDialog)
 * dan Pengalaman (dengan ExposedDropdownMenu).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateAndExperienceSection(
    birthDate: String,
    onBirthDateChange: (String) -> Unit,
    experience: String,
    onExperienceChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val density = LocalDensity.current
    val textStyle = TextStyle(
        fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() }
    )

    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colorResource(id = R.color.input_border_focused),
        unfocusedBorderColor = colorResource(id = R.color.input_border_unfocused),
        focusedTextColor = colorResource(id = R.color.text_label),
        unfocusedTextColor = colorResource(id = R.color.text_label),
        cursorColor = colorResource(id = R.color.title_purple)
    )

    val cornerRadius = dimensionResource(id = R.dimen.input_corner_radius)
    val shape = RoundedCornerShape(cornerRadius)

    val dateFormatPattern = stringResource(id = R.string.date_format_display)
    val calendar = Calendar.getInstance()
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val formattedDate = String.format(dateFormatPattern, dayOfMonth, month + 1, year)
                onBirthDateChange(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    var dropdownExpanded by remember { mutableStateOf(false) }
    val experienceOptions = listOf(
        stringResource(id = R.string.exp_less_than_1),
        stringResource(id = R.string.exp_1_to_3),
        stringResource(id = R.string.exp_3_to_5),
        stringResource(id = R.string.exp_more_than_5)
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_date_exp_row))
    ) {
        // Field Tanggal Lahir
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { datePickerDialog.show() }
                )
        ) {
            OutlinedTextField(
                value = birthDate,
                onValueChange = {},
                readOnly = true,
                enabled = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.label_tgl_lahir),
                        color = colorResource(id = R.color.input_placeholder),
                        fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() }
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = stringResource(id = R.string.desc_calendar_icon),
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.icon_size))
                            .clickable { datePickerDialog.show() },
                        tint = colorResource(id = R.color.input_placeholder)
                    )
                },
                singleLine = true,
                textStyle = textStyle,
                shape = shape,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = colorResource(id = R.color.input_border_unfocused),
                    disabledTextColor = colorResource(id = R.color.text_label),
                    disabledPlaceholderColor = colorResource(id = R.color.input_placeholder)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Field Experience Dropdown
        ExposedDropdownMenuBox(
            expanded = dropdownExpanded,
            onExpandedChange = { dropdownExpanded = !dropdownExpanded },
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(
                value = experience,
                onValueChange = {},
                readOnly = true,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.label_experience),
                        color = colorResource(id = R.color.input_placeholder),
                        fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() }
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dropdown),
                        contentDescription = stringResource(id = R.string.desc_dropdown_icon),
                        modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
                        tint = colorResource(id = R.color.input_placeholder)
                    )
                },
                singleLine = true,
                textStyle = textStyle,
                shape = shape,
                colors = fieldColors,
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false }
            ) {
                experienceOptions.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() },
                                color = colorResource(id = R.color.text_label)
                            )
                        },
                        onClick = {
                            onExperienceChange(option)
                            dropdownExpanded = false
                        }
                    )
                }
            }
        }
    }
}
