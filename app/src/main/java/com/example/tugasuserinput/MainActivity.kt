package com.example.tugasuserinput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasuserinput.ui.components.DateAndExperienceSection
import com.example.tugasuserinput.ui.components.EmailInputSection
import com.example.tugasuserinput.ui.components.FormHeaderSection
import com.example.tugasuserinput.ui.components.HeaderSection
import com.example.tugasuserinput.ui.components.NameInputSection
import com.example.tugasuserinput.ui.components.ProceedButtonSection
import com.example.tugasuserinput.ui.components.SkillCheckboxSection
import com.example.tugasuserinput.ui.theme.TugasUserInputTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasUserInputTheme {
                BiodataScreen()
            }
        }
    }
}

@Composable
fun BiodataScreen(modifier: Modifier = Modifier) {
    var formState by remember { mutableStateOf(FormBiodataState()) }
    val scrollState = rememberScrollState()

    val cardCornerRadius = dimensionResource(id = R.dimen.card_corner_radius)
    val floatingBoxShape = RoundedCornerShape(
        topStart = cardCornerRadius,
        topEnd = cardCornerRadius
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(id = R.color.scaffold_background)
    ) { innerPadding ->
        // Box utama sebagai canvas di dalam Scaffold
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 1. Gambar profil/header di bagian atas
            HeaderSection()

            // 2. Komponen Box yang mengapung di atas Scaffold
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = dimensionResource(id = R.dimen.floating_box_top_offset))
                    .shadow(
                        elevation = dimensionResource(id = R.dimen.floating_box_elevation),
                        shape = floatingBoxShape
                    )
                    .background(
                        color = colorResource(id = R.color.card_surface),
                        shape = floatingBoxShape
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_form_horizontal),
                            end = dimensionResource(id = R.dimen.padding_form_horizontal),
                            top = dimensionResource(id = R.dimen.padding_form_vertical),
                            bottom = dimensionResource(id = R.dimen.padding_form_bottom)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Header form (Judul dan Subjudul)
                    FormHeaderSection()

                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_subtitle_to_form))
                    )

                    // Input Nama Depan dan Belakang
                    NameInputSection(
                        firstName = formState.firstName,
                        onFirstNameChange = { formState = formState.copy(firstName = it) },
                        lastName = formState.lastName,
                        onLastNameChange = { formState = formState.copy(lastName = it) }
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_between_fields))
                    )

                    // Input Email
                    EmailInputSection(
                        email = formState.email,
                        onEmailChange = { formState = formState.copy(email = it) }
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_between_fields))
                    )

                    // Input Tanggal Lahir dan Pengalaman
                    DateAndExperienceSection(
                        birthDate = formState.birthDate,
                        onBirthDateChange = { formState = formState.copy(birthDate = it) },
                        experience = formState.experience,
                        onExperienceChange = { formState = formState.copy(experience = it) }
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_form_to_skills))
                    )

                    // Pilihan Keahlian (Checkboxes)
                    SkillCheckboxSection(
                        isAndroid = formState.isSkillAndroid,
                        onAndroidChange = { formState = formState.copy(isSkillAndroid = it) },
                        isUiUx = formState.isSkillUiUx,
                        onUiUxChange = { formState = formState.copy(isSkillUiUx = it) },
                        isWeb = formState.isSkillWeb,
                        onWebChange = { formState = formState.copy(isSkillWeb = it) }
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_checkboxes_to_button))
                    )

                    // Tombol Aksi Proceed dan Dialog Konfirmasi
                    ProceedButtonSection(
                        state = formState,
                        onProceedClick = { formState = formState.copy(showResultDialog = true) },
                        onDismissDialog = { formState = formState.copy(showResultDialog = false) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BiodataScreenPreview() {
    TugasUserInputTheme {
        BiodataScreen()
    }
}