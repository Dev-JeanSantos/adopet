package com.fourtk.adopet.TutorResponsesDTO

data class TutorResponsePaginationDTO (
        val name: String,
        val email: String,
        var address: String,
        var city: String,
        var uf: String,
        var phone: String,
        var image: String?,
)
