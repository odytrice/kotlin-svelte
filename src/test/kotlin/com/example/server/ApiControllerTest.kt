package com.example.server

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.http.MediaType
import com.example.server.controller.ApiController

@WebMvcTest(ApiController::class)
class ApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `hello endpoint returns 200 OK`() {
        mockMvc.perform(get("/api/hello"))
            .andExpect(status().isOk)
    }

    @Test
    fun `hello endpoint returns JSON content type`() {
        mockMvc.perform(get("/api/hello"))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun `hello endpoint returns correct message`() {
        mockMvc.perform(get("/api/hello"))
            .andExpect(jsonPath("$.text").value("Hello World from Kotlin!"))
    }
}
