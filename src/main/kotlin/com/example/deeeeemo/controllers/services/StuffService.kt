package com.example.deeeeemo.controllers.services

import com.example.deeeeemo.controllers.DTO.StuffDTO

interface StuffService {
    fun getStuff() : List<StuffDTO>
    fun getSpecificStuff(id: Long): StuffDTO
}