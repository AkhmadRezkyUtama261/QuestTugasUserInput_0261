package com.example.tugasuserinput

/**
 * Data class untuk menampung seluruh state input pada Form Biodata.
 */
data class FormBiodataState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val birthDate: String = "",
    val experience: String = "",
    val isSkillAndroid: Boolean = false,
    val isSkillUiUx: Boolean = false,
    val isSkillWeb: Boolean = false,
    val showResultDialog: Boolean = false
)
