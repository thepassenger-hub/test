package com.example.deeeeemo.controllers

import com.example.deeeeemo.controllers.DTO.StuffDTO
import com.example.deeeeemo.controllers.services.StuffService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestController(
    private val stuffService: StuffService
) {

    @GetMapping("/")
    fun getAllStuff() : List<StuffDTO>{
        return stuffService.getStuff()
        // call service s
//
    }
    @GetMapping("/stuff/{id}")
    fun getAllStuff(@PathVariable id: Long) : StuffDTO{
        return stuffService.getSpecificStuff(id)
        // call service s
//
    }
}