package com.dubproductions.empowertakehome.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dubproductions.empowertakehome.domain.model.Beneficiary
import com.dubproductions.empowertakehome.domain.repository.BeneficiariesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeneficiariesScreenViewModel @Inject constructor(
    private val beneficiariesRepository: BeneficiariesRepository
): ViewModel() {

    private val _beneficiariesList = MutableStateFlow(listOf<Beneficiary>())
    val beneficiariesList = _beneficiariesList.asStateFlow()

    private val _selectedBeneficiary = MutableStateFlow<Beneficiary?>(null)
    val selectedBeneficiary = _selectedBeneficiary.asStateFlow()

    init {
        fetchBeneficiariesData()
    }

    // Update beneficiary selection
    fun changeSelectBeneficiary(beneficiary: Beneficiary?) {
        _selectedBeneficiary.update {
            beneficiary
        }
    }

    // Update the flow for the list of beneficiaries
    private fun updateBeneficiariesFlow(newList: List<Beneficiary>) {
        _beneficiariesList.update {
            newList
        }
    }

    // Fetch the list of beneficiaries from the repository
    private fun fetchBeneficiariesData() {
        viewModelScope.launch {
            val newList = async {
                beneficiariesRepository.fetchBeneficiariesList()
            }
            updateBeneficiariesFlow(newList.await())
        }

    }

}
