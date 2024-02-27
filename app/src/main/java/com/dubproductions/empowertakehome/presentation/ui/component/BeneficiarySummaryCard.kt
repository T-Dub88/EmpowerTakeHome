package com.dubproductions.empowertakehome.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dubproductions.empowertakehome.R
import com.dubproductions.empowertakehome.domain.model.Beneficiary
import com.dubproductions.empowertakehome.utils.BeneficiaryStringConversion

/**
 * Card for displaying basic information about a beneficiary.
 * Clicking the card will navigate to a screen showing detailed information
 * about the selected beneficiary.
 */
@Composable
fun BeneficiarySummaryCard(
    beneficiary: Beneficiary,
    onClick: (Beneficiary) -> Unit
) {
    Card(
        onClick = { onClick(beneficiary) },
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(id = R.string.first_name, beneficiary.firstName))
        Text(text = stringResource(id = R.string.last_name, beneficiary.lastName))
        Text(text = stringResource(id = R.string.type, beneficiary.beneType))
        Text(
            text = stringResource(
                id = R.string.designation,
                BeneficiaryStringConversion.setDesignation(beneficiary.designationCode)
            ),
        )
    }
}
