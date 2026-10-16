package com.example.tugasuserinput.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.tugasuserinput.R

/**
 * Komponen input baris ganda untuk Nama Depan dan Nama Belakang.
 */
@Composable
fun NameInputSection(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
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

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_name_row))
    ) {
        OutlinedTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.label_first_name),
                    color = colorResource(id = R.color.input_placeholder),
                    fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() }
                )
            },
            singleLine = true,
            textStyle = textStyle,
            shape = shape,
            colors = fieldColors,
            modifier = Modifier.weight(1f)
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.label_last_name),
                    color = colorResource(id = R.color.input_placeholder),
                    fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() }
                )
            },
            singleLine = true,
            textStyle = textStyle,
            shape = shape,
            colors = fieldColors,
            modifier = Modifier.weight(1f)
        )
    }
}
