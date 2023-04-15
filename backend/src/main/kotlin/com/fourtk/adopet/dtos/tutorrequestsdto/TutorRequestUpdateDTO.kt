package com.fourtk.adopet.dtos.tutorrequestsdto

data class TutorRequestUpdateDTO (
        val id: Long,
        val name: String,
        val email: String,
        val password: String,
        val cpf: String,
        val address: String,
        val city: String,
        val uf: String,
        val phone: String,
        val image: String? = ""
)
