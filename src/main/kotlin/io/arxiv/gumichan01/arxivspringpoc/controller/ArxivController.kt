package io.arxiv.gumichan01.arxivspringpoc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ArxivController() {

    @GetMapping("/")
    fun home(): String {
        return "Hello Arxiv client\n"
    }

    @GetMapping("/search/")
    fun search(@RequestParam(value = "q", required = true) query: String): String {
        return "response"
    }
}