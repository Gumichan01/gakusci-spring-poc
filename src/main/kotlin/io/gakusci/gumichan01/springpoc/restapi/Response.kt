package io.gakusci.gumichan01.springpoc.restapi

import com.fasterxml.jackson.annotation.JsonProperty

// HAL Archives ouvertes response data
data class HalResponse(val response: HalResponseBody)
data class HalResponseBody(val numFound: Int, val start: Int, val docs: List<HalResultEntry>?)

data class HalResultEntry(val docid: Int, @JsonProperty("label_s") val label: String,
                          @JsonProperty("uri_s") val uri: String)

// Arxiv response data

// TODO define classes