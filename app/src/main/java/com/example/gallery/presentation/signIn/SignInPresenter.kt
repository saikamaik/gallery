package com.example.gallery.presentation.signIn

import android.widget.EditText
import com.example.gallery.db.AppDao
import com.google.android.material.textfield.TextInputLayout
import moxy.MvpPresenter
import javax.inject.Inject

class SignInPresenter @Inject constructor(
    private var appDao: AppDao
)
    : MvpPresenter<SignInView>() {

    fun signInUser(email: EditText, password: EditText) {

        setError(email, null)
        setError(password, null)

        if (appDao.isUserExist(email.text.toString())) {
            val user = appDao.getOneUser(email.text.toString())
            if (user.password == password.text.toString()) {
                viewState.navigateToHomeFragment()
                appDao.updateCurrentUserField(true, user.email)
            } else {
                setError(password, "Пароль не верный")
            }
        }
        else {
            setError(email, "Пользователя с такой почтой не существует")
        }
    }

    fun resetCurrentUser() {
        val userList = appDao.getAllUsers()
        for (user in userList) {
            appDao.updateCurrentUserField(false, user.email)
        }
    }

    private fun setError(data: EditText, error: String?) {
        if (data.parent.parent is TextInputLayout) {
            (data.parent.parent as TextInputLayout).error = error
        }
    }


}