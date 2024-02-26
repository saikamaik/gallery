package com.example.gallery.presentation.popularPhotoFragment

import com.example.gallery.db.AppDao
import com.example.gallery.db.entity.PhotoDto
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PopularPhotoPresenter @Inject constructor(
    private var appDao: AppDao
): MvpPresenter<PopularPhotoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initRecyclerView()
    }

    fun insertPhoto(photo: PhotoDto) {
        appDao.insertPhoto(photo)
    }

    fun getPopularPhotos(): List<PhotoDto> {
        return appDao.getAllTypedPhotos("popular")
    }

    fun navigateToPhotoInfoFragment(item: PhotoDto) {
        viewState.navigateToPhotoInfoFragment(item)
    }


}