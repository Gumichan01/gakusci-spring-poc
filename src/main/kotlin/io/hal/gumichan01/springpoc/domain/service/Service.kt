package io.hal.gumichan01.springpoc.domain.service

import io.hal.gumichan01.springpoc.domain.model.DocumentEntry
import io.hal.gumichan01.springpoc.restapi.HalRestTemplate
import org.springframework.stereotype.Service

@Service
class Service(val halRestTemplate: HalRestTemplate) {

    fun searchForResourceName(query: String): List<DocumentEntry> {
        return halRestTemplate.search(query).map { e -> DocumentEntry(e.label, e.uri) }
    }
}