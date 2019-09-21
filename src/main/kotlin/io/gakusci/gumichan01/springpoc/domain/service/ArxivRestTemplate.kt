package io.gakusci.gumichan01.springpoc.domain.service

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class ArxivRestTemplate {

    private val arxivUrl = "https://export.arxiv.org/api/query?search_query=%s"
    private val restTemplate: RestTemplate = RestTemplate()

    fun search(query: String): String {
        // TODO search and return result properly
        val url = arxivUrl.format(query)
        val result: String? = restTemplate.getForObject(url)
        return result ?: "BAKA"
    }
}