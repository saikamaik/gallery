package com.example.gallery.di

import com.example.gallery.App
import com.example.gallery.presentation.newPhotoFragment.NewPhotoPresenter
import com.example.gallery.presentation.photoInfoFragment.PhotoInfoPresenter
import com.example.gallery.presentation.popularPhotoFragment.PopularPhotoPresenter
import com.example.gallery.presentation.signIn.SignInPresenter
import com.example.gallery.presentation.signUp.SignUpPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(target: App)

    fun provideSignUpPresenter(): SignUpPresenter

    fun provideSignInPresenter(): SignInPresenter

//    fun provideHomePresenter(): HomePresenter

    fun provideNewPhotoPresenter(): NewPhotoPresenter

    fun providePopularPhotoPresenter(): PopularPhotoPresenter

    fun providePhotoInfoPresenter(): PhotoInfoPresenter

}