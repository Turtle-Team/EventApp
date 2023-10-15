package com.turtleteam.impl.data

import com.turtleteam.api.FeatureOneRepository

class FeatureOneRepositoryImpl: FeatureOneRepository {
    override fun fetchEvents(): List<String> {
        return listOf("bebebe","bebe","be")
    }
}