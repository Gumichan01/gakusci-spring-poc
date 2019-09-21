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
        return """<p>Hello Gakusci POC client</p>
            <p>/!\This webapp is a Proof of Concept/!\</p>
            <strong>DO NOT USE IT IN PRODUCTION</strong>"""
    }

    @GetMapping("/search/")
    fun search(@RequestParam(value = "q", required = true) query: String): List<DocumentEntry> {
        return service.searchForResourceName(query)
    }
}