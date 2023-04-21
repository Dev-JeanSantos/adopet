package com.fourtk.adopet.services

import com.fourtk.adopet.exceptions.NotFoundException
import com.fourtk.adopet.mappers.TutorRequestMapper
import com.fourtk.adopet.mappers.TutorResponseMapper
import com.fourtk.adopet.mappers.TutorResponsePaginationMapper
import com.fourtk.adopet.model.TutorResponsePaginationDTOTest
import com.fourtk.adopet.model.TutorTest
import com.fourtk.adopet.models.Tutor
import com.fourtk.adopet.repositories.TutorRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TutorServiceTest {

    val tutors = PageImpl(listOf(TutorTest.build()))

    val pagination: Pageable = mockk()

    val tutorRepository: TutorRepository = mockk(){
        every { findByName(any(), any()) } returns tutors
        every { findAll(pagination) } returns tutors
        every { findById(any()) } returns Optional.empty()
    }
    private val tutorResponsePaginationMapper: TutorResponsePaginationMapper = mockk(){
        every { map(any()) } returns (TutorResponsePaginationDTOTest.build())

    }
    private val tutorRequestMapper: TutorRequestMapper = mockk()
    private val tutorResponseMapper: TutorResponseMapper = mockk()

    val tutorService = TutorService(
        tutorRequestMapper, tutorResponseMapper,  tutorResponsePaginationMapper, tutorRepository
    )

    @Test
    fun `should list tutors starting from the name of the tutor`(){

        tutorService.listar("Paulo Pedro", pagination)

        verify (exactly = 1){ tutorRepository.findByName(any(), any())  }
        verify (exactly = 1){ tutorResponsePaginationMapper.map(any())  }
        verify (exactly = 0){ tutorRepository.findAll(pagination)  }
    }

    @Test
    fun `Should list all topics when tutor name is null`(){
        tutorService.listar(null, pagination)

        verify (exactly = 0){ tutorRepository.findByName(any(), any())  }
        verify (exactly = 1){ tutorResponsePaginationMapper.map(any())  }
        verify (exactly = 1){ tutorRepository.findAll(pagination)  }
    }

    @Test
    fun `should return a Not Found Exception when a tutor is not found`(){

        val actual = assertThrows<NotFoundException> {
            tutorService.getByIdTutor(1)
        }
            assertThat(actual.message).isEqualTo("Tutor not found!")

    }

}