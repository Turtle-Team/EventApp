package com.turtleteam.api

interface FeatureOneRepository {
    fun fetchEvents(): List<String>
}