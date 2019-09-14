package io.arxiv.gumichan01.arxivspringpoc.domain.service

import io.arxiv.gumichan01.arxivspringpoc.domain.model.DocumentEntry
import org.springframework.stereotype.Service

@Service
class ArxivService {

    // TODO call the Arxiv Web service

    fun searchForResourceName(query: String): List<DocumentEntry> {
        return listOf(DocumentEntry("hello", "#"))
    }
}