package com.example.server.controller

import com.example.server.model.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/hello")
    fun hello(): Message = Message(text = "Hello World from Kotlin!")
}
