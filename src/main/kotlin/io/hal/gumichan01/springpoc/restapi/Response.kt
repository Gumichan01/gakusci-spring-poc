package io.hal.gumichan01.springpoc.restapi

import com.fasterxml.jackson.annotation.JsonProperty

data class ArxivResponse(val response: ArxivResponseBody)
data class ArxivResponseBody(val numFound: Int, val start: Int, val docs: List<ArxivResultEntry>?)

data class ArxivResultEntry(val docid: Int, @JsonProperty("label_s") val label: String,
                            @JsonProperty("uri_s") val uri: String)