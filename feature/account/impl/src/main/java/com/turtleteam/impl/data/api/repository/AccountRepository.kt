package com.turtleteam.impl.data.api.repository

import com.turtleteam.api.data.api.model.UserDTOReceive
import com.turtleteam.api.data.api.repository.AccountRepository
import com.turtleteam.core_network.BaseRepository
import io.ktor.client.HttpClient
import io.ktor.http.HttpMethod

class AccountRepositoryImpl(private val httpClient: HttpClient) : AccountRepository,
    BaseRepository(httpClient) {

    override suspend fun registerUser(user: UserDTOReceive) {
        val body = """
                {
                  "login": "${user.login}",
                  "password": "${user.password}"
                }
            """.trimIndent()
        executeCall(
            type = HttpMethod.Post,
            path = "/user/get",
            body = body
        )
    }

    override suspend fun authUser(login: String, password: String): String {
        val body = """
                {
                  "login": "$login",
                  "password": "$password"
                }
            """.trimIndent()
        val response = executeCall(
            type = HttpMethod.Get,
            path = "/user/get",
            body = body
        )
        return response
    }
}