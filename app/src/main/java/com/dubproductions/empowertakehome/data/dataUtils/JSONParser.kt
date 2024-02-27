package com.dubproductions.empowertakehome.data.dataUtils

import android.content.Context
import android.util.Log
import com.dubproductions.empowertakehome.domain.model.Beneficiary
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class JSONParser(
    private val context: Context
) {

    fun parseFile(): List<Beneficiary> {

        return try {
            val jsonString = context.assets.open("Beneficiaries.json").bufferedReader().use { it.readText() }
            Json.decodeFromString<List<Beneficiary>>(jsonString)
        } catch (e: Exception) {
            Log.e("JSONParser", "parseFile: $e")
            listOf()
        }

    }

}
