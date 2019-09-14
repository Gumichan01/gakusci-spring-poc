package io.arxiv.gumichan01.arxivspringpoc.restapi

import com.fasterxml.jackson.annotation.JsonProperty

data class ArxivResultEntry(val docid: Int, @JsonProperty("label_s") val label: String,
                            @JsonProperty("uri_s") val uri: String)