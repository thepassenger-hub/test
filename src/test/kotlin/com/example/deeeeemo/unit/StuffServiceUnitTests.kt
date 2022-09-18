package com.example.deeeeemo.unit

import com.example.deeeeemo.controllers.DTO.StuffDTO
import com.example.deeeeemo.controllers.domain.Stuff
import com.example.deeeeemo.controllers.domain.toDTO
import com.example.deeeeemo.controllers.repository.StuffRepository
import com.example.deeeeemo.controllers.services.StuffService
import com.example.deeeeemo.controllers.services.StuffServiceImpl
import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockkObject
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*


@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest(StuffService::class)
class StuffServiceUnitTests(
    @MockK private val stuffRepository: StuffRepository
){

    private val stuffService = StuffServiceImpl(stuffRepository)


//     = StuffServiceImpl(stuffRepository)
    private val stuff = Stuff(
    1,
    "dunno",
    30
)
    @Test
    fun `assert that get specific stuff returns an existing object if present in the db` (){
        mockkObject(stuff)
        every { stuffRepository.findById(any()) } returns Optional.of(stuff)
        assertDoesNotThrow { stuffService.getSpecificStuff(2) }
    }

    @Test
    fun `assert that an exception is thrown if the object is not in the db` () {
        every { stuffRepository.findById(any()) } returns Optional.empty()
        assertThrows<NotFoundException> { stuffService.getSpecificStuff(4) }
    }

    @Test
    fun`assert getStuff returns a non empty list if theres an elem in db`(){
        mockkObject(stuff)
        every { stuffRepository.findAll() } returns listOf(stuff)
        assert( stuffService.getStuff().size == 1)
        assertDoesNotThrow {  stuffService.getStuff()}
    }
    @Test
    fun`assert getStuff returns an empty list if there isn't any elem in db`(){
        every { stuffRepository.findAll() } returns emptyList()
        assert( stuffService.getStuff().size == 0)
        assertDoesNotThrow {  stuffService.getStuff()}
    }
}
//
//override fun getStuff(): List<StuffDTO> {
//    return stuffRepository.findAll().map { it.toDTO() }.toList()
//}
//@Service
//class StuffServiceImpl(
//    private val stuffRepository: StuffRepository
//) : StuffService {
//    override fun getSpecificStuff(id: Long): StuffDTO {
//        val stuff = stuffRepository.findById(id)
//        if (stuff.isEmpty) throw ChangeSetPersister.NotFoundException() else return stuff.get().toDTO()
