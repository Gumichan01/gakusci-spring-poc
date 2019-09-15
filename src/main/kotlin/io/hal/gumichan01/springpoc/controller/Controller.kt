package io.hal.gumichan01.springpoc.controller

import io.hal.gumichan01.springpoc.domain.model.DocumentEntry
import io.hal.gumichan01.springpoc.domain.service.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val service: Service) {

    @GetMapping("/")
    fun home(): String {
        return "Hello Arxiv client\n"
    }

    @GetMapping("/search/")
    fun search(@RequestParam(value = "q", required = true) query: String): List<DocumentEntry> {
        return service.searchForResourceName(query)
    }
}