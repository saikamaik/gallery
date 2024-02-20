package com.example.gallery.presentation.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.gallery.App
import com.example.gallery.R
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

        binding.toolbarCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
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

    override fun showToast(id: Int) {
        Toast.makeText(requireContext(), id, Toast.LENGTH_SHORT).show()
    }

}