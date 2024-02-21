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
import com.example.gallery.db.entity.UserDto
import com.example.gallery.presentation.signIn.SignInFragmentDirections
import com.example.gallery.utils.DateUtils
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SignUpFragment : MvpAppCompatFragment(), SignUpView {

    @InjectPresenter
    lateinit var presenter: SignUpPresenter

    @ProvidePresenter
    fun providePresenter(): SignUpPresenter = App.appComponent.provideSignUpPresenter()

    private lateinit var binding: FragmentSignupBinding
    private val dateUtils = DateUtils()

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

        binding.toolbarCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonSignIn.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }

        binding.buttonSignUp.setOnClickListener {
            signUpUser()
        }

    }

    private fun signUpUser() {
        if (presenter.validateUser(
                binding.etConfirmPassword,
                binding.etPassword,
                binding.etEmail,
                binding.etUsername
            )
        ) {
            val userDto = UserDto(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString(),
                binding.etUsername.text.toString(),
                dateUtils.convertFromStringToDate(binding.etBirthday.text.toString()),
                isCurrentUser = true
            )
            presenter.registerUser(userDto, binding.etEmail)
        }
    }

    override fun navigateToHomeFragment() {
        presenter.resetCurrentUser()
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeFragment())
    }
}