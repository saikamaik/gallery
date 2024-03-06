package com.example.gallery.utils

import android.content.Context
import android.util.Patterns
import com.example.gallery.R
import com.google.android.material.textfield.TextInputLayout

class Validator(var context: Context) {

    fun validateEmail(emailTextInputLayout: TextInputLayout): Boolean {
        val email: String = emailTextInputLayout.editText?.text.toString()

        return if (email.isEmpty()) {
            emailTextInputLayout.error = context.getString(R.string.editText_cant_be_empty)
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTextInputLayout.error = context.getString(R.string.email_is_wrong)
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
            passwordTextInputLayout.error = context.getString(R.string.passwords_doesnt_match)
            false
        } else if (password.isEmpty()) {
            passwordTextInputLayout.error = context.getString(R.string.editText_cant_be_empty)
            false
        } else {
            passwordTextInputLayout.error = null
            true
        }
    }

    fun validateUserName(userNameTextInputLayout: TextInputLayout): Boolean {
        val userName: String = userNameTextInputLayout.editText?.text.toString()

        return if (userName.isEmpty()) {
            userNameTextInputLayout.error = context.getString(R.string.editText_cant_be_empty)
            return false
        } else {
            userNameTextInputLayout.error = null
            true
        }
    }

    fun validateBirthday(birthdayTextInputLayout: TextInputLayout): Boolean {
        val birthday: String = birthdayTextInputLayout.editText?.text.toString()

        return if (birthday.isEmpty()) {
            birthdayTextInputLayout.error = context.getString(R.string.editText_cant_be_empty)
            return false
        } else {
            birthdayTextInputLayout.error = null
            true
        }
    }

}