package com.example.deeeeemo.controllers.DTO

data class StuffDTO(
    val id : Long,
    var address: String,
    val items: Int
){
    init {
        address = normalize(address)
    }
}

fun normalize(address: String): String {
    return "NORMALIZED ADDR"
}