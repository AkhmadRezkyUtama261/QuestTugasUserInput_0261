package com.example.tugasuserinput.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import com.example.tugasuserinput.R

/**
 * Komponen input untuk Alamat Email pengguna.
 */
@Composable
fun EmailInputSection(
    email: String,
    onEmailChange: (String) -> Unit,
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

    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.label_email),
                color = colorResource(id = R.color.input_placeholder),
                fontSize = with(density) { dimensionResource(id = R.dimen.text_size_input).toSp() }
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = textStyle,
        shape = shape,
        colors = fieldColors,
        modifier = modifier.fillMaxWidth()
    )
}
