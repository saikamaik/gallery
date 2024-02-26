package com.example.gallery.presentation.signIn

import android.content.Context
import android.widget.EditText
import com.example.gallery.R
import com.example.gallery.db.AppDao
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SignInPresenter @Inject constructor(
    private var appDao: AppDao,
    var context: Context
)
    : MvpPresenter<SignInView>() {

    fun signInUser(email: EditText, password: EditText) {

        if (appDao.isUserExist(email.text.toString())) {

            val user = appDao.getOneUser(email.text.toString())
            if (user.password == password.text.toString()) {
                viewState.navigateToHomeFragment()
                appDao.updateCurrentUserField(true, user.email)
            } else {
                password.error = context.getString(R.string.passwords_doesnt_match)
            }
        } else {
            email.error = context.getString(R.string.user_doesnt_exist)
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
        viewState.navigateToSignUpFragment()
    }
}