package com.example.gallery.presentation.signUp

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.gallery.App
import com.example.gallery.databinding.FragmentSignupBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SignUpFragment : MvpAppCompatFragment(), SignUpView {

    @InjectPresenter
    lateinit var presenter: SignUpPresenter

    @ProvidePresenter
    fun providePresenter(): SignUpPresenter = App.appComponent.provideSignUpPresenter()

    private lateinit var binding: FragmentSignupBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(layoutInflater)
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

        binding.buttonSignIn.setOnClickListener {
            presenter.navigateToSignUp()
        }

        binding.buttonSignUp.setOnClickListener {
            presenter.signUpUser(
                binding.tlConfirmPassword,
                binding.tlPassword,
                binding.tlEmail,
                binding.tlUsername,
                binding.tlBirthday
            )
        }
    }

    override fun navigateToHomeFragment() {
        presenter.resetCurrentUser()
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeFragment())
    }

    override fun navigateUp() {
        findNavController().popBackStack()
    }

    override fun navigateToSignInFragment() {
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
    }
}