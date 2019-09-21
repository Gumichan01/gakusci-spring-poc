package io.gakusci.gumichan01.springpoc.domain.service

import io.gakusci.gumichan01.springpoc.domain.model.DocumentEntry
import io.gakusci.gumichan01.springpoc.restapi.HalRestTemplate
import org.springframework.stereotype.Service

@Service
class HalService(val halRestTemplate: HalRestTemplate) : IService {

    override fun searchForResourceName(query: String): List<DocumentEntry> {
        return halRestTemplate.search(query).map { e -> DocumentEntry(e.label, e.uri) }
    }
}