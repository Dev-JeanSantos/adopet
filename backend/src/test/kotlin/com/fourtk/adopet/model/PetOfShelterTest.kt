package com.fourtk.adopet.model

import com.fourtk.adopet.vo.PetOfShelterVo

object PetOfShelterTest {
    fun build() = PetOfShelterVo(
        nameShelter = "Casa do Animal Feliz",
        nameCity = "Ribeirão Preto",
        QuantityPets = 200
    )
}