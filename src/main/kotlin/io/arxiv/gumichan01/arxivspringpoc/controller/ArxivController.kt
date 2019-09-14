package io.arxiv.gumichan01.arxivspringpoc.controller

import io.arxiv.gumichan01.arxivspringpoc.domain.service.ArxivService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ArxivController(@Autowired val arxivService: ArxivService) {

    @GetMapping("/")
    fun home(): String {
        return "Hello Arxiv client\n"
    }

    @GetMapping("/search/")
    fun search(@RequestParam(value = "q", required = true) query: String): String {
        val searchForResourceName = arxivService.searchForResourceName(query)
        return searchForResourceName.toString()
    }
}