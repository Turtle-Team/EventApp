package com.turtleteam.data.network.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.appendPathSegments
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseRepository: KoinComponent {

    private val httpClient: HttpClient by inject()

    protected suspend fun executeCall(
        type: HttpMethod,
        path: String,
        parameters: Map<String, String>? = null,
        headers: Map<String, String>? = null,
        body: String? = null
    ): String {
        val url = ""
        val response: HttpResponse
        try {
            response = httpClient.request(url) {
                url {
                   appendPathSegments(path)
                    parameters?.forEach { this.parameters.append(it.key, it.value) }
                }
                method = type
                headers?.forEach { this.headers.append(it.key, it.value) }
                body?.let { setBody(body) }
            }
        } catch (e: SocketTimeoutException) {
            throw Exception(e)
        } catch (e: IOException) {
            throw Exception(e)
        }

        if (response.status.value !in 200..299) {
            throw Exception(response.status.description)
        }
        return response.body()
    }
}
