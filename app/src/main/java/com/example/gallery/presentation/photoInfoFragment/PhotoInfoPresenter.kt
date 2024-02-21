package com.example.gallery.presentation.photoInfoFragment

import com.example.gallery.db.AppDao
import com.example.gallery.db.entity.PhotoDto
import moxy.MvpPresenter
import javax.inject.Inject

class PhotoInfoPresenter @Inject constructor(
    private val appDao: AppDao
) : MvpPresenter<PhotoInfoView>() {

    fun getOnePhoto(id: Int): PhotoDto {
       return appDao.getOnePhoto(id)
    }

}