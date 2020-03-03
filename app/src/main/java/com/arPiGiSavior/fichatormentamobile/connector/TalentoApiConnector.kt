package com.arPiGiSavior.fichatormentamobile.connector

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class TalentoApiConnector {

    companion object {
        val URL = "https://radiant-depths-67651.herokuapp.com/graphql"

        fun setupConnection(): ApolloClient {
            val okHttpClient = OkHttpClient.Builder().build()
            return ApolloClient.builder().serverUrl(URL).okHttpClient(okHttpClient).build()
        }
    }
}