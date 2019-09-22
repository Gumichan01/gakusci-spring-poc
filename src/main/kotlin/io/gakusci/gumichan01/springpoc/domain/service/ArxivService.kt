package io.gakusci.gumichan01.springpoc.domain.service

import io.gakusci.gumichan01.springpoc.domain.model.DocumentEntry
import io.gakusci.gumichan01.springpoc.restapi.label
import org.springframework.stereotype.Service

@Service
class ArxivService(val arxivRestTemplate: ArxivRestTemplate) : IService {
    override suspend fun searchForResourceName(query: String): List<DocumentEntry> {
        return arxivRestTemplate.search(query).map { e -> DocumentEntry(e.label(), e.link) }
    }
}