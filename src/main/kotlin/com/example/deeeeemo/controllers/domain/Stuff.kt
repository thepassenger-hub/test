package com.example.deeeeemo.controllers.domain

import com.example.deeeeemo.controllers.DTO.StuffDTO
import javax.persistence.*


@Entity
class Stuff(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "address")
    val address: String,

    @Column(name = "items")
    val items: Int
)

fun Stuff.toDTO() = StuffDTO(
    id = id!!,
    items = items,
    address = address
)
