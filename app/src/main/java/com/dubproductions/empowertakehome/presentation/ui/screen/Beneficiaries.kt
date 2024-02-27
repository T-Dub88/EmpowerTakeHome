package com.dubproductions.empowertakehome.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dubproductions.empowertakehome.domain.model.Beneficiary
import com.dubproductions.empowertakehome.presentation.ui.component.BeneficiaryDetailsDialog
import com.dubproductions.empowertakehome.presentation.ui.component.BeneficiarySummaryCard

@Composable
fun BeneficiariesScreen(
    beneficiariesList: List<Beneficiary>,
    selectedBeneficiary: Beneficiary?,
    onBeneficiarySelect: (Beneficiary) -> Unit,
    onDismissDialog: () -> Unit
) {
    // Displays the list of beneficiaries
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp)
            .padding(horizontal = 8.dp)
    ) {
        // Represents each item in the list
        items(beneficiariesList) { beneficiary ->
            BeneficiarySummaryCard(
                beneficiary = beneficiary,
                onClick = onBeneficiarySelect
            )
        }
    }

    // Will show dialog if a beneficiary is selected
    selectedBeneficiary?.let {
        BeneficiaryDetailsDialog(
            beneficiary = it,
            onDismiss = onDismissDialog
        )
    }

}
