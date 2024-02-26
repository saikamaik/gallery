package com.example.gallery.presentation.signUp

import android.content.Context
import com.example.gallery.R
import com.example.gallery.db.AppDao
import com.example.gallery.db.entity.UserDto
import com.example.gallery.utils.DateUtils
import com.example.gallery.utils.Validator
import com.google.android.material.textfield.TextInputLayout
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SignUpPresenter @Inject constructor(
    var appDao: AppDao,
    val context: Context
) : MvpPresenter<SignUpView>() {

    private var validate: Validator = Validator()
    private val dateUtils = DateUtils()

    private fun registerUser(userDto: UserDto, emailTextInputLayout: TextInputLayout) {

        if (appDao.isUserExist(userDto.email)) {
            emailTextInputLayout.error = context.getString(R.string.user_already_exist)
        } else {
            appDao.insertUser(userDto)
            viewState.navigateToHomeFragment()
        }
    }

    private fun validateUser(
        confirmPasswordTextInputLayout: TextInputLayout,
        passwordTextInputLayout: TextInputLayout,
        emailTextInputLayout: TextInputLayout,
        usernameTextInputLayout: TextInputLayout,
        birthdayTextInputLayout: TextInputLayout
    ): Boolean {
        return if (
            validate.validateEmail(emailTextInputLayout) &&
            validate.validatePassword(passwordTextInputLayout, confirmPasswordTextInputLayout) &&
            validate.validateUserName(usernameTextInputLayout) &&
            validate.validateBirthday(birthdayTextInputLayout)
        ) return true
        else false
    }

    fun signUpUser(
        confirmPasswordTextInputLayout: TextInputLayout,
        passwordTextInputLayout: TextInputLayout,
        emailTextInputLayout: TextInputLayout,
        usernameTextInputLayout: TextInputLayout,
        birthdayTextInputLayout: TextInputLayout
    ) {
        if (validateUser(
                confirmPasswordTextInputLayout,
                passwordTextInputLayout,
                emailTextInputLayout,
                usernameTextInputLayout,
                birthdayTextInputLayout
            )
        ) {
            val userDto = UserDto(
                emailTextInputLayout.editText?.text.toString(),
                passwordTextInputLayout.editText.toString(),
                usernameTextInputLayout.editText?.text.toString(),
                dateUtils.convertFromStringToDate(birthdayTextInputLayout.editText?.text.toString()),
                isCurrentUser = true
            )
            registerUser(userDto, emailTextInputLayout)
        }
    }

    fun resetCurrentUser() {
        val userList = appDao.getAllUsers()
        for (user in userList) {
            appDao.updateCurrentUserField(false, user.email)
        }
    }

    fun navigateUp() {
        viewState.navigateUp()
    }

    fun navigateToSignUp() {
        viewState.navigateToSignInFragment()
    }

}
