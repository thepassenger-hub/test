package com.example.deeeeemo.integration

import com.example.deeeeemo.controllers.repository.StuffRepository
import com.example.deeeeemo.controllers.services.StuffService
import com.example.deeeeemo.controllers.services.StuffServiceImpl
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class StuffServiceIntegrationTests(
    @Autowired private val stuffService: StuffService,
) {

    @Test
    fun `make sure get stuff with id 1 gets the object`(){
        assertDoesNotThrow { stuffService.getSpecificStuff(1) }
    }
}