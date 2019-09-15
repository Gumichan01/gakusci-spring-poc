package io.arxiv.gumichan01.arxivspringpoc.restapi

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class ArxivRestTemplate {

    private val arxivUrl = "https://api.archives-ouvertes.fr/search/?q=%s&wt=json"
    private val restTemplate: RestTemplate = RestTemplate()

    fun search(query: String): List<ArxivResultEntry> {
        val url = arxivUrl.format(query)
        val jsonResponse = restTemplate.getForObject<String>(url)
        val arxivResult: ArxivResult = ObjectMapper().readValue(jsonResponse, object : TypeReference<ArxivResult>() {})
        return arxivResult.docs
    }
}