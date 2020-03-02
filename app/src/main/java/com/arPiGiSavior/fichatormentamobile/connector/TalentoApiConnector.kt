package com.arPiGiSavior.fichatormentamobile.connector

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class TalentoApiConnector {

    companion object {
        val URL = "http://192.168.0.106:8080/graphql"

        fun setupConnection(): ApolloClient {
            val okHttpClient = OkHttpClient.Builder().build()
            return ApolloClient.builder().serverUrl(URL).okHttpClient(okHttpClient).build()
        }
    }
}