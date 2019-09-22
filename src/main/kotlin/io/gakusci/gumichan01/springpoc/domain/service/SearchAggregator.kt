package io.gakusci.gumichan01.springpoc.domain.service

import io.gakusci.gumichan01.springpoc.restapi.HalRestTemplate
import org.springframework.stereotype.Component

@Component
class SearchAggregator(private val services: Set<IService> = setOf(HalService(HalRestTemplate()), ArxivService(ArxivRestTemplate()))) {

    fun search(query: String) = services.map { s -> s.searchForResourceName(query) }.flatten()
}