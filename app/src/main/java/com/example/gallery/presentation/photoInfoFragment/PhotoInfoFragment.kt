package com.example.gallery.presentation.photoInfoFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.gallery.App
import com.example.gallery.databinding.FragmentPhotoInfoBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PhotoInfoFragment: MvpAppCompatFragment(), PhotoInfoView {

    private lateinit var binding: FragmentPhotoInfoBinding
    private val args: PhotoInfoFragmentArgs by navArgs()

    @InjectPresenter
    lateinit var presenter: PhotoInfoPresenter

    @ProvidePresenter
    fun providePresenter(): PhotoInfoPresenter = App.appComponent.providePhotoInfoPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val photoId: Int = args.id
        initView(photoId)

    }

    private fun initView(id: Int) {
        val photo = presenter.getOnePhoto(id)
        binding.ivInfo.load(photo.photoUrl)
        binding.tvPhotoName.text = photo.photoType

        binding.toolbarCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}