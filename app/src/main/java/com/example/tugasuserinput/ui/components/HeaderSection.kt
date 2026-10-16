package com.example.tugasuserinput.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.tugasuserinput.R

/**
 * Komponen header untuk menampilkan foto profil di bagian atas Scaffold.
 */
@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.img_header),
        contentDescription = stringResource(id = R.string.desc_header_photo),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.header_image_height)),
        contentScale = ContentScale.Crop
    )
}
