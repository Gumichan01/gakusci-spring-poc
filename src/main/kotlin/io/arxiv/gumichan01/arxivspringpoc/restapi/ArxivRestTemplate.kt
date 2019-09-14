package io.arxiv.gumichan01.arxivspringpoc.restapi

import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.lang.reflect.ParameterizedType

@Component
class ArxivRestTemplate {

    val arxivUrl = "https://api.archives-ouvertes.fr/search/?q=%s&wt=json"
    val restTemplate: RestTemplate = RestTemplate()

    fun search(query: String): String {
        val url = arxivUrl.format(query)
        val results = restTemplate.getForEntity(url, ParameterizedTypeReference<List<DocumentResultEntry>>)
        return "BAKA"
    }
}