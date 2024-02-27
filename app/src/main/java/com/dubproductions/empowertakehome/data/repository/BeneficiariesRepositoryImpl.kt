package com.dubproductions.empowertakehome.data.repository

import com.dubproductions.empowertakehome.data.dataUtils.JSONParser
import com.dubproductions.empowertakehome.domain.model.Beneficiary
import com.dubproductions.empowertakehome.domain.repository.BeneficiariesRepository

class BeneficiariesRepositoryImpl(
    private val jsonParser: JSONParser
): BeneficiariesRepository {
    override fun fetchBeneficiariesList(): List<Beneficiary> {
        return jsonParser.parseFile()
    }
}
