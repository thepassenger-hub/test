package com.example.deeeeemo.controllers.repository

import com.example.deeeeemo.controllers.domain.Stuff
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StuffRepository : CrudRepository<Stuff,Long>{
}