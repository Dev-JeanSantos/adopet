package com.fourtk.adopet.dtos.adoptionresponse

class AdoptionResponseDTO(
    val nameTutor: String,
    var phoneTutor: String,
    var imageTutor: String?,
    val namePet: String,
    val nameShelter: String,
    val specie: String,
    val age: Int,
    val ageMonthOrYear: String,
    val genre: String,
    val carrying: String,
    val personality: String,
    val status: String,
    val descriptionPet: String,
    val imagePet: String?,
    val city: String,
    val uf: String
)