package com.fourtk.adopet.model

import com.fourtk.adopet.models.Tutor

object UserTest {
    fun build() = Tutor(
        id = 1,
        name = "Joao Pedro",
        email = "email@gmail.com",
        password = ""
    )
}