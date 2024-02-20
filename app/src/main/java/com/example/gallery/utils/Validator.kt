package com.example.gallery.utils

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class Validator {

    fun validateEmail(emailEditText: EditText): Boolean {
        val email: String = emailEditText.toString()

        return if (email.isEmpty()) {
            setError(emailEditText, "Поле не должно быть пустым")
            return false
        } else {
            setError(emailEditText, null)
            true
        }
    }

    fun validatePassword(passwordEditText: EditText, confirmPasswordEditText: EditText): Boolean {
        val password: String = passwordEditText.text.toString()
        val confirmPassword: String = confirmPasswordEditText.text.toString()

        return if (password != confirmPassword) {
            setError(passwordEditText, "Пароли не совпадают")
            false
        } else if (password.isEmpty()) {
            setError(passwordEditText, "Поле не должно быть пустым")
            false
        } else {
            setError(passwordEditText, null)
            true
        }
    }

    fun validateUserName(userNameEditText: EditText): Boolean {
        val userName: String = userNameEditText.toString()

        return if (userName.isEmpty()) {
            setError(userNameEditText, "Поле не должно быть пустым")
            return false
        } else {
            setError(userNameEditText, null)
            true
        }
    }

    private fun setError(data: EditText, error: String?) {
        if (data.parent.parent is TextInputLayout) {
            (data.parent.parent as TextInputLayout).error = error
        }
    }

}