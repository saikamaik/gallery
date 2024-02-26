package com.example.gallery.presentation.photoInfoFragment

import com.example.gallery.db.AppDao
import com.example.gallery.db.entity.PhotoDto
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PhotoInfoPresenter @Inject constructor(
    private val appDao: AppDao
) : MvpPresenter<PhotoInfoView>() {

    fun getOnePhoto(id: Int): PhotoDto {
       return appDao.getOnePhoto(id)
    }

}