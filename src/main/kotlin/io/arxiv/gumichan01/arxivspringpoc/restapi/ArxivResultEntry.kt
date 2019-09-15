package io.arxiv.gumichan01.arxivspringpoc.restapi

import com.fasterxml.jackson.annotation.JsonProperty

data class ArxivResult(val numFound: Int, val start: Int, val docs: List<ArxivResultEntry>)

data class ArxivResultEntry(val docid: Int, @JsonProperty("label_s") val label: String,
                            @JsonProperty("uri_s") val uri: String)