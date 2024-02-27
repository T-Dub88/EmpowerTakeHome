package com.dubproductions.empowertakehome.utils

object BeneficiaryStringConversion {
    /**
     * Manages the conversion of designation codes to a string
     * for display to the user.
     */
    fun setDesignation(designationCode: String): String {
        return when (designationCode) {
            "P" -> "Primary"
            else -> "Contingent"
        }
    }

    /**
     * Manages the conversion of date of birth strings to a more readable
     * format.
     */
    fun formatDateOfBirth(dob: String): String {
        var newDOB = ""
        var i = 0
        for (char in dob) {
            newDOB += char
            when (i) {
                1, 3 -> newDOB += "/"
            }
            i += 1
        }

        return newDOB
    }

    /**
     * Manages the conversion of phone number strings to a more readable format.
     */
    fun formatPhoneNumber(number: String): String {
        var newPhone = ""
        var i = 0
        for (char in number) {
            when (i) {
                0 -> newPhone += "("
                3 -> newPhone += ")"
                6 -> newPhone += "-"
            }
            newPhone += char

            i += 1
        }
        return newPhone
    }

}