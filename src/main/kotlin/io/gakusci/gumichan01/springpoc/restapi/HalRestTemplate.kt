package io.gakusci.gumichan01.springpoc.restapi

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
class HalRestTemplate {

    private val halUrl = "https://api.archives-ouvertes.fr/search/?q=%s&wt=json"
    private val restTemplate: RestTemplate = RestTemplate()

    fun search(query: String): List<HalResultEntry> {
        val url = halUrl.format(query)
        val halResponse: HalResponse? = restTemplate.getForObject(url)
        return halResponse?.response?.docs ?: listOf()
    }
}