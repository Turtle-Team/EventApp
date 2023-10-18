package com.turtleteam.impl.data.api.service

import com.google.common.hash.Hashing
import com.turtleteam.api.data.api.model.UserDTOReceive
import com.turtleteam.api.data.api.repository.AccountRepository
import com.turtleteam.api.data.api.service.AccountService
import java.nio.charset.StandardCharsets

class AccountServiceImpl(private val repository: AccountRepository) : AccountService {

    override suspend fun registerUser(user: UserDTOReceive) {
        val password = Hashing.sha256()
            .hashString(user.password, StandardCharsets.UTF_8)
            .toString()
        val userHashing = UserDTOReceive(
            login = user.login,
            password = password
        )
        repository.registerUser(userHashing)
    }

    override suspend fun authUser(login: String, password: String): String {
        val passwordHashing = Hashing.sha256()
            .hashString(password, StandardCharsets.UTF_8)
            .toString()
        return repository.authUser(login, passwordHashing)
    }
}