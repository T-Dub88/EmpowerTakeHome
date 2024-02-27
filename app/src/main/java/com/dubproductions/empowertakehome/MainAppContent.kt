package com.dubproductions.empowertakehome

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dubproductions.empowertakehome.presentation.ui.screen.BeneficiariesScreen
import com.dubproductions.empowertakehome.presentation.ui.theme.EmpowerTakeHomeTheme
import com.dubproductions.empowertakehome.presentation.ui.viewmodel.BeneficiariesScreenViewModel

@Composable
fun MainAppContent() {
    EmpowerTakeHomeTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            // Normally would be in the nav graph if one existed
            // ViewModel for beneficiary screen
            val beneficiaryViewModel  = hiltViewModel<BeneficiariesScreenViewModel>()

            // Collector for beneficiary list
            val beneficiaryList by beneficiaryViewModel.beneficiariesList.collectAsStateWithLifecycle()
            // Collector for selected beneficiary state
            val selectedBeneficiary by beneficiaryViewModel.selectedBeneficiary.collectAsStateWithLifecycle()

            // Main screen of the application
            BeneficiariesScreen(
                beneficiariesList = beneficiaryList,
                selectedBeneficiary = selectedBeneficiary,
                onBeneficiarySelect = {
                    beneficiaryViewModel.changeSelectBeneficiary(it)
                },
                onDismissDialog = {
                    beneficiaryViewModel.changeSelectBeneficiary(null)
                }
            )

        }

    }

}
