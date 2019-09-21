package io.gakusci.gumichan01.springpoc.domain.service

import io.gakusci.gumichan01.springpoc.domain.model.DocumentEntry
import org.springframework.stereotype.Service

@Service
class ArxivService(val arxivRestTemplate: ArxivRestTemplate): IService {
    override fun searchForResourceName(query: String): List<DocumentEntry> {
        val result = arxivRestTemplate.search(query)
        println(result)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}