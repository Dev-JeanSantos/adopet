package com.fourtk.adopet.services

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
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class TutorServiceTest {

    val tutors = PageImpl(listOf(TutorTest.build()))

    val pagination: Pageable = mockk()

    val tutorRepository: TutorRepository = mockk(){
        every { findByName(any(), any()) } returns tutors
    }
    private val tutorResponsePaginationMapper: TutorResponsePaginationMapper = mockk()
    private val tutorRequestMapper: TutorRequestMapper = mockk()
    private val tutorResponseMapper: TutorResponseMapper = mockk()

    val tutorService = TutorService(
        tutorRequestMapper, tutorResponseMapper,  tutorResponsePaginationMapper, tutorRepository
    )

    @Test
    fun `should list tutors starting from the name of the tutor`(){
        every { tutorResponsePaginationMapper.map(any()) } returns (TutorResponsePaginationDTOTest.build())

        tutorService.listar("Paulo Pedro", pagination)

        verify (exactly = 1){ tutorRepository.findByName(any(), any())  }
        verify (exactly = 1){ tutorResponsePaginationMapper.map(any())  }
        verify (exactly = 0){ tutorRepository.findAll(pagination)  }
    }


}