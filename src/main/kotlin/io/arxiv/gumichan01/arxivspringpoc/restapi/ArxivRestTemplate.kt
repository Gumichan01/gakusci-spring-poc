package io.arxiv.gumichan01.arxivspringpoc.restapi

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
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
        val mapper = jacksonObjectMapper()
        val arxivResult: ArxivResponse = mapper.readValue(jsonResponse, object : TypeReference<ArxivResponse>() {})
        return arxivResult.response.docs ?: listOf()
    }
}