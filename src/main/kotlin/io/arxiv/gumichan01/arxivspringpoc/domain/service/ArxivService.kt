package io.arxiv.gumichan01.arxivspringpoc.domain.service

import io.arxiv.gumichan01.arxivspringpoc.domain.model.DocumentEntry
import io.arxiv.gumichan01.arxivspringpoc.restapi.ArxivRestTemplate
import org.springframework.stereotype.Service

@Service
class ArxivService(val arxivRestTemplate: ArxivRestTemplate) {

    fun searchForResourceName(query: String): List<DocumentEntry> {
        return arxivRestTemplate.search(query).map { e -> DocumentEntry(e.label, e.uri) }
    }
}