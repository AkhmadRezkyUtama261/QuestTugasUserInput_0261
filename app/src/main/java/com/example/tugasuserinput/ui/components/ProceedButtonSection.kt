package com.example.tugasuserinput.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.tugasuserinput.FormBiodataState
import com.example.tugasuserinput.R

/**
 * Komponen tombol aksi Proceed beserta Dialog untuk menampilkan data yang berhasil diisi.
 */
@Composable
fun ProceedButtonSection(
    state: FormBiodataState,
    onProceedClick: () -> Unit,
    onDismissDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val buttonTextSize = with(density) { dimensionResource(id = R.dimen.text_size_button).toSp() }
    val labelSize = with(density) { dimensionResource(id = R.dimen.text_size_label).toSp() }

    Button(
        onClick = onProceedClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.button_height)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.button_proceed_bg),
            contentColor = colorResource(id = R.color.button_proceed_text)
        )
    ) {
        Text(
            text = stringResource(id = R.string.btn_proceed),
            color = colorResource(id = R.color.button_proceed_text),
            fontSize = buttonTextSize,
            fontWeight = FontWeight.Bold
        )
    }

    if (state.showResultDialog) {
        val notSpecified = stringResource(id = R.string.text_not_specified)
        val noneText = stringResource(id = R.string.text_none)

        val skillsList = mutableListOf<String>()
        if (state.isSkillAndroid) skillsList.add(stringResource(id = R.string.skill_android))
        if (state.isSkillUiUx) skillsList.add(stringResource(id = R.string.skill_ui_ux))
        if (state.isSkillWeb) skillsList.add(stringResource(id = R.string.skill_web))
        val skillsDisplay = if (skillsList.isEmpty()) noneText else skillsList.joinToString(", ")

        val firstNameDisplay = state.firstName.ifBlank { notSpecified }
        val lastNameDisplay = state.lastName.ifBlank { "" }
        val emailDisplay = state.email.ifBlank { notSpecified }
        val birthDateDisplay = state.birthDate.ifBlank { notSpecified }
        val experienceDisplay = state.experience.ifBlank { notSpecified }

        AlertDialog(
            onDismissRequest = onDismissDialog,
            title = {
                Text(
                    text = stringResource(id = R.string.dialog_title_success),
                    color = colorResource(id = R.color.title_purple),
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column {
                    Text(
                        text = stringResource(id = R.string.dialog_label_nama, firstNameDisplay, lastNameDisplay).trim(),
                        fontSize = labelSize,
                        color = colorResource(id = R.color.text_label)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_title_to_subtitle)))
                    Text(
                        text = stringResource(id = R.string.dialog_label_email, emailDisplay),
                        fontSize = labelSize,
                        color = colorResource(id = R.color.text_label)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_title_to_subtitle)))
                    Text(
                        text = stringResource(id = R.string.dialog_label_tgl_lahir, birthDateDisplay),
                        fontSize = labelSize,
                        color = colorResource(id = R.color.text_label)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_title_to_subtitle)))
                    Text(
                        text = stringResource(id = R.string.dialog_label_experience, experienceDisplay),
                        fontSize = labelSize,
                        color = colorResource(id = R.color.text_label)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_title_to_subtitle)))
                    Text(
                        text = stringResource(id = R.string.dialog_label_skill, skillsDisplay),
                        fontSize = labelSize,
                        color = colorResource(id = R.color.text_label)
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = onDismissDialog) {
                    Text(
                        text = stringResource(id = R.string.dialog_btn_close),
                        color = colorResource(id = R.color.title_purple),
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            containerColor = colorResource(id = R.color.card_surface)
        )
    }
}
