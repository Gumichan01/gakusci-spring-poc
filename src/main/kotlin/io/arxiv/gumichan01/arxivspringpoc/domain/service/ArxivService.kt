package io.arxiv.gumichan01.arxivspringpoc.domain.service

import io.arxiv.gumichan01.arxivspringpoc.domain.model.DocumentEntry
import io.arxiv.gumichan01.arxivspringpoc.restapi.ArxivRestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class ArxivService(@Autowired val arxivRestTemplate: ArxivRestTemplate) {

    fun searchForResourceName(query: String): List<DocumentEntry> {
        val result = arxivRestTemplate.search(query)
        val logger: Logger = Logger.getLogger(ArxivService::class.toString())
        logger.info(result)
        return listOf(DocumentEntry("hello", "#"))
    }
}