package io.gakusci.gumichan01.springpoc.domain.service

import io.gakusci.gumichan01.springpoc.domain.model.DocumentEntry
import io.gakusci.gumichan01.springpoc.restapi.HalRestTemplate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class SearchAggregator(private val services: Set<IService> = setOf(HalService(HalRestTemplate()), ArxivService(ArxivRestTemplate()))) {

    @ExperimentalCoroutinesApi
    fun search(query: String): List<DocumentEntry> {
        val channels: List<ReceiveChannel<DocumentEntry>> = services.map { s ->
            CoroutineScope(Dispatchers.Default).produce<DocumentEntry>(capacity = 100) { s.searchForResourceName(query).forEach { e -> channel.send(e) } }
        }
        var documentEntries: MutableList<DocumentEntry> = mutableListOf()
        println("IN")
        runBlocking {
            channels.forEach { channel -> channel.consumeEach { entry -> println(entry.url); documentEntries.add(entry) } }
        }
        println("OUT")
        return documentEntries
    }
}