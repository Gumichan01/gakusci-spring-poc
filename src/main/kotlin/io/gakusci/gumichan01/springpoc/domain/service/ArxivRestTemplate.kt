package io.gakusci.gumichan01.springpoc.domain.service

import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import io.gakusci.gumichan01.springpoc.restapi.ArxivResultEntry
import io.gakusci.gumichan01.springpoc.utils.ImmutableList
import org.springframework.stereotype.Component
import java.net.URL

@Component
class ArxivRestTemplate {

    private val arxivUrl = "https://export.arxiv.org/api/query?search_query=%s"

    fun search(query: String): List<ArxivResultEntry> {
        val url = arxivUrl.format(query)
        return SyndFeedInput().build(XmlReader(URL(url))).entries.map {
            e -> ArxivResultEntry(ImmutableList(e.authors), e.title, e.publishedDate, e.link)
        }
    }
}