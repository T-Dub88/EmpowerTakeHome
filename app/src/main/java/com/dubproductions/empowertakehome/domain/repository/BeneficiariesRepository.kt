package com.dubproductions.empowertakehome.domain.repository

import com.dubproductions.empowertakehome.domain.model.Beneficiary

interface BeneficiariesRepository {
    fun fetchBeneficiariesList(): List<Beneficiary>
}
