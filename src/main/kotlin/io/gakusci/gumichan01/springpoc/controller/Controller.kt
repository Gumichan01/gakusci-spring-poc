package io.gakusci.gumichan01.springpoc.controller

import io.gakusci.gumichan01.springpoc.domain.service.SearchAggregator
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val searchAggregator: SearchAggregator) {

    @GetMapping("/search")
    fun search(@RequestParam(value = "q", required = true) query: String, model: Model): Model {
        val results = searchAggregator.search(query)
        model.addAttribute("entries", results)
        return model
    }
}