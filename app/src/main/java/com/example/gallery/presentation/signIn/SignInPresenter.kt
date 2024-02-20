package com.example.gallery.presentation.signIn

import android.widget.EditText
import com.example.gallery.R
import com.example.gallery.db.AppDao
import com.google.android.material.textfield.TextInputLayout
import moxy.MvpPresenter
import javax.inject.Inject

class SignInPresenter @Inject constructor(
    var appDao: AppDao
)
    : MvpPresenter<SignInView>() {

    fun signInUser(email: String, password: String) {
        if (appDao.isUserExist(email)) {
            val user = appDao.getOneUser(email)
            if (user.password == password) {
                viewState.navigateToHomeFragment()
                appDao.updateCurrentUserField(true, user.email)
            } else {
                viewState.showToast(R.string.passwords_doesnt_match)
            }
        }
        else {
            viewState.showToast(R.string.user_doesnt_exist)
        }
    }

    fun resetCurrentUser() {
        val userList = appDao.getAllUsers()
        for (user in userList) {
            appDao.updateCurrentUserField(false, user.email)
        }
    }

}