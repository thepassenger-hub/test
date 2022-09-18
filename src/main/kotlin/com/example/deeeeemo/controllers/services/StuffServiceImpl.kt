package com.example.deeeeemo.controllers.services

import com.example.deeeeemo.controllers.DTO.StuffDTO
import com.example.deeeeemo.controllers.domain.toDTO
import com.example.deeeeemo.controllers.repository.StuffRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class StuffServiceImpl(
    private val stuffRepository: StuffRepository
) : StuffService {
    override fun getSpecificStuff(id: Long): StuffDTO {
        val stuff = stuffRepository.findById(id)
        if (stuff.isEmpty) throw NotFoundException() else return stuff.get().toDTO()
    }

    override fun getStuff(): List<StuffDTO> {
        return stuffRepository.findAll().map { it.toDTO() }.toList()
    }
}