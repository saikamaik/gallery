package com.example.gallery.presentation.signUp

import android.widget.EditText
import android.widget.Toast
import com.example.gallery.db.AppDao
import com.example.gallery.db.entity.UserDto
import com.example.gallery.utils.Validator
import com.google.android.material.textfield.TextInputLayout
import moxy.MvpPresenter
import javax.inject.Inject

class SignUpPresenter @Inject constructor(
    var appDao: AppDao
) : MvpPresenter<SignUpView>() {

    private var validate: Validator = Validator()

    fun registerUser(userDto: UserDto, emailEditText: EditText) {

        if (appDao.isUserExist(userDto.email)) {
            setError(emailEditText, "Пользователь с такой почтой уже существует")
        } else {
            appDao.insertUser(userDto)
            viewState.navigateToHomeFragment()
        }
    }

    fun validateUser(
        confirmPasswordEditText: EditText,
        passwordEditText: EditText,
        emailEditText: EditText,
        usernameEditText: EditText
    ): Boolean {
        return if (
            validate.validateEmail(emailEditText) &&
            validate.validatePassword(passwordEditText, confirmPasswordEditText) &&
            validate.validateUserName(usernameEditText)
        ) return true
        else false
    }

    private fun setError(data: EditText, error: String?) {
        if (data.parent.parent is TextInputLayout) {
            (data.parent.parent as TextInputLayout).error = error
        }
    }

    fun resetCurrentUser() {
        val userList = appDao.getAllUsers()
        for (user in userList) {
            appDao.updateCurrentUserField(false, user.email)
        }
    }

}