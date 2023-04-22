package com.fourtk.adopet.integration

import com.fourtk.adopet.model.PetTest
import com.fourtk.adopet.model.ShelterTeste
import com.fourtk.adopet.model.TutorTest
import com.fourtk.adopet.repositories.PetRepository
import com.fourtk.adopet.repositories.ShelterRepository
import com.fourtk.adopet.repositories.TutorRepository
import com.fourtk.adopet.vo.PetOfShelterVo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShelterRepositoryTest {

    @Autowired
    private lateinit var repositoryShelter: ShelterRepository

    @Autowired
    private lateinit var repositoryPet: PetRepository

    @Autowired
    private lateinit var repositoryTutor: TutorRepository

    private val tutor = TutorTest.build()
    private val shelter = ShelterTeste.build()
    private val pet = PetTest.build()

    companion object {

        @Container
        private val mysqlContainer = MySQLContainer<Nothing>("mysql:8.0.28").apply {
            withDatabaseName("testdb")
            withUsername("jean")
            withPassword("123456")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
        }
    }

    @Test
    fun `Should generate a report of the number of pets per shelter`() {

        val tutors =repositoryTutor.save(tutor)
        val shelters = repositoryShelter.save(shelter)
        val pets = repositoryPet.save(pet)

        val reporters = repositoryShelter.getTotalPetsByShelter()

        assertThat(reporters).isNotNull
        assertThat(reporters.first()).isExactlyInstanceOf(PetOfShelterVo::class.java)
    }
}