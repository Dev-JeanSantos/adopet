package com.fourtk.adopet.controllers

import com.fourtk.adopet.config.JWTUtil
import com.fourtk.adopet.models.Role
import com.fourtk.adopet.model.UserTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.web.servlet.get
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class TutorControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Autowired
    private lateinit var jwtUtil: JWTUtil
    private lateinit var mockMvc: MockMvc
    private var jwt: String? = "null"

    companion object {
        private const val TOKEN = "%s"
        private const val RECURSO = "/pets"
        private const val RECURSO_ID = RECURSO.plus("%s")
    }

    @BeforeEach
    fun setup() {
        jwt = gerarToken()
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder?>(
                SecurityMockMvcConfigurers.springSecurity()
            ).build()
    }

//    @Test
//    fun `Should return 400 when triggering a token less request`() {
//        mockMvc.get(RECURSO).andExpect { status { is4xxClientError() } }
//    }

//    @Test
//    fun `should return code 200 when calling topics and user is authenticated`(){
//        mockMvc.get(RECURSO){
//            headers {this.setBearerAuth(TOKEN.format(jwt))}
//        }.andExpect { status { isOk() } }
//    }
//
//    @Test
//    fun `should return code 404 when calling topics by id that does not exist even with an authenticated user`(){
//        mockMvc.get(RECURSO_ID.format(1)){
//            headers {this.setBearerAuth(TOKEN.format(jwt))}
//        }.andExpect { status { is4xxClientError()} }
//    }


    private fun gerarToken(): String? {
        val authorities = mutableListOf(Role(1, "READ_WRITE"))
        val user = UserTest.build()
        return jwtUtil.generateToken(user.email, authorities)
    }
}