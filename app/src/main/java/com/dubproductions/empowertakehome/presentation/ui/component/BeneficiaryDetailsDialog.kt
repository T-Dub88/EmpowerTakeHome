package com.dubproductions.empowertakehome.presentation.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.dubproductions.empowertakehome.R
import com.dubproductions.empowertakehome.domain.model.Beneficiary
import com.dubproductions.empowertakehome.utils.BeneficiaryStringConversion

/**
 * Dialog for displaying extra details about the selected
 * beneficiary
 */
@Composable
fun BeneficiaryDetailsDialog(
    beneficiary: Beneficiary,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Card{
            // Name as a header
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                text = stringResource(
                    id = R.string.name_header,
                    beneficiary.firstName,
                    beneficiary.middleName,
                    beneficiary.lastName
                )
            )
            Text(
                text = stringResource(
                    id = R.string.ssn,
                    beneficiary.socialSecurityNumber
                )
            )
            Text(
                text = stringResource(
                    id = R.string.dob,
                    BeneficiaryStringConversion.formatDateOfBirth(beneficiary.dateOfBirth)
                )
            )
            Text(
                text = stringResource(
                    id = R.string.phone,
                    BeneficiaryStringConversion.formatPhoneNumber(beneficiary.phoneNumber)
                )
            )
            Text(
                text = stringResource(
                    id = R.string.address,
                    beneficiary.beneficiaryAddress.firstLineMailing,
                    beneficiary.beneficiaryAddress.scndLineMailing ?: stringResource(id = R.string.empty),
                    beneficiary.beneficiaryAddress.city,
                    beneficiary.beneficiaryAddress.stateCode,
                    beneficiary.beneficiaryAddress.country,
                    beneficiary.beneficiaryAddress.zipCode
                )
            )
            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.dismiss))
            }
        }
    }
}
