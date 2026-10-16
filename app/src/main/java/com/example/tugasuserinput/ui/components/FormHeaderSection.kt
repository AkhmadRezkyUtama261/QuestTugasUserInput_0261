package com.example.tugasuserinput.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.tugasuserinput.R

/**
 * Komponen header untuk Form Biodata yang berisi judul dan subjudul.
 */
@Composable
fun FormHeaderSection(
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.title_form_biodata),
            color = colorResource(id = R.color.title_purple),
            fontSize = with(density) { dimensionResource(id = R.dimen.text_size_title).toSp() },
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_title_to_subtitle))
        )

        Text(
            text = stringResource(id = R.string.subtitle_form_biodata),
            color = colorResource(id = R.color.subtitle_gray),
            fontSize = with(density) { dimensionResource(id = R.dimen.text_size_subtitle).toSp() },
            textAlign = TextAlign.Center
        )
    }
}
