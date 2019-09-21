package io.gakusci.gumichan01.springpoc.controller

import io.gakusci.gumichan01.springpoc.domain.model.DocumentEntry
import io.gakusci.gumichan01.springpoc.domain.service.ArxivService
import io.gakusci.gumichan01.springpoc.domain.service.HalService
import io.gakusci.gumichan01.springpoc.domain.service.IService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val halService: HalService, val arxivService: ArxivService) {

    @GetMapping("/")
    fun home(): String {
        return """<p>Hello Gakusci POC client</p>
            <p>/!\ This webapp is a Proof of Concept /!\</p>
            <strong>DO NOT USE IT IN PRODUCTION</strong>"""
    }

    @GetMapping("/search/")
    fun search(@RequestParam(value = "q", required = true) query: String): List<DocumentEntry> {
        return arxivService.searchForResourceName(query)
        // return halService.searchForResourceName(query)
    }
}