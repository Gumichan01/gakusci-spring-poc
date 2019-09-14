package io.arxiv.gumichan01.arxivspringpoc.restapi

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class ArxivRestTemplate {

    val arxivUrl = "https://api.archives-ouvertes.fr/search/?q=%s&wt=json"
    val restTemplate: RestTemplate = RestTemplate()

    fun search(query: String): String {
        val request = arxivUrl.format(query)
        val result: ArxivResult? = restTemplate.getForObject(request, ArxivResult::class)
        return result?.toString() ?: ""
    }
}