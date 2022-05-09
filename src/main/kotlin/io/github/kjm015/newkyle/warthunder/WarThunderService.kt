package io.github.kjm015.newkyle.warthunder

import io.github.kjm015.newkyle.warthunder.model.WarThunderResponse
import io.github.kjm015.newkyle.warthunder.model.WarThunderStats
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.net.URL

@Service
class WarThunderService(private val restTemplate: RestTemplate) {

    fun getStatsForPlayer(player: String): WarThunderStats {
        val url = "https://thunderskill.com/en/stat/$player"
        val webURI = URI(url)
        val exportURI = URI("$url/export/json")

        val headers = HttpHeaders()
        headers.set("User-Agent", "New Kyle")

        val entity = HttpEntity<WarThunderResponse>(headers)



        val response = try {
            restTemplate.exchange(exportURI, HttpMethod.GET, entity, typeReference<WarThunderResponse>())
        } catch (e: Exception) {
            val connection = URL(url).openConnection()
            connection.setRequestProperty("User-Agent", "New Kyle")
            connection.setRequestProperty("Connection", "close")
            connection.connectTimeout = 1000 * 30
            connection.connect()
            // Thread.sleep(29500)
            restTemplate.exchange(exportURI, HttpMethod.GET, entity, typeReference<WarThunderResponse>())
        }

        val resp = response.body as WarThunderResponse
        return resp.stats
    }

    // Inline function to typecast incoming JSON to a provided type reference
    private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}
}