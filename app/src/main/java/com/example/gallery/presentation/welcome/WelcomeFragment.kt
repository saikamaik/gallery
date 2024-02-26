package com.example.gallery.presentation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gallery.R
import com.example.gallery.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignIn.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

//        val sceneRoot: ViewGroup = binding.sceneRoot
//        val signInScene: Scene = Scene.getSceneForLayout(sceneRoot, R.layout.fragment_signin, this.context)
//        val signUpScene: Scene = Scene.getSceneForLayout(sceneRoot, R.layout.fragment_signup, this.context)

    }
}