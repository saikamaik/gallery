package com.example.gallery.utils

import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout

class Validator {

    fun validateEmail(emailTextInputLayout: TextInputLayout): Boolean {
        val email: String = emailTextInputLayout.editText?.text.toString()

        return if (email.isEmpty()) {
            emailTextInputLayout.error = "Поле не должно быть пустым"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTextInputLayout.error = "E-mail введен некорректно"
            false
        }
        else {
            emailTextInputLayout.error = null
            true
        }
    }

    fun validatePassword(passwordTextInputLayout: TextInputLayout, confirmPasswordTextInputLayout: TextInputLayout): Boolean {
        val password: String = passwordTextInputLayout.editText?.text.toString()
        val confirmPassword: String = confirmPasswordTextInputLayout.editText?.text.toString()

        return if (password != confirmPassword) {
            passwordTextInputLayout.error = "Пароли не совпадают"
            false
        } else if (password.isEmpty()) {
            passwordTextInputLayout.error = "Поле не должно быть пустым"
            false
        } else {
            passwordTextInputLayout.error = null
            true
        }
    }

    fun validateUserName(userNameTextInputLayout: TextInputLayout): Boolean {
        val userName: String = userNameTextInputLayout.editText?.text.toString()

        return if (userName.isEmpty()) {
            userNameTextInputLayout.error = "Поле не должно быть пустым"
            return false
        } else {
            userNameTextInputLayout.error = null
            true
        }
    }

    fun validateBirthday(birthdayTextInputLayout: TextInputLayout): Boolean {
        val birthday: String = birthdayTextInputLayout.editText?.text.toString()

        return if (birthday.isEmpty()) {
            birthdayTextInputLayout.error = "Поле не должно быть пустым"
            return false
        } else {
            birthdayTextInputLayout.error = null
            true
        }
    }

}