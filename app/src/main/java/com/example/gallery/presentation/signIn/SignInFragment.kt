package com.example.gallery.presentation.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gallery.App
import com.example.gallery.databinding.FragmentSigninBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SignInFragment: MvpAppCompatFragment(), SignInView {

    @InjectPresenter
    lateinit var presenter: SignInPresenter

    @ProvidePresenter
    fun providePresenter(): SignInPresenter = App.appComponent.provideSignInPresenter()

    private lateinit var binding: FragmentSigninBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSigninBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListeners()

    }

    private fun setUpListeners() {
        binding.toolbarCancel.setOnClickListener {
            presenter.navigateUp()
        }

        binding.buttonSignUp.setOnClickListener {
            presenter.navigateToSignUp()
        }

        binding.buttonSignIn.setOnClickListener {
            presenter.signInUser(
                binding.etEmail,
                binding.etPassword
            )
        }
    }

    override fun navigateToHomeFragment() {
        presenter.resetCurrentUser()
        findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToHomeFragment())
    }

    override fun navigateUp() {
        findNavController().popBackStack()
    }

    override fun navigateToSignUpFragment() {
        findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
    }

}