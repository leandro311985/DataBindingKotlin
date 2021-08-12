package com.example.myapplication.next

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventForgotPassword.observe(this, Observer { isForgotPassword ->
            if (isForgotPassword) {
                goToForgotPassword()
                viewModel.onEventForgotPasswordComplete()
            }
        })

        viewModel.eventOnError.observe(this, Observer { errorMessage ->
            if (!errorMessage.isNullOrEmpty()) {
                showError(errorMessage)
                viewModel.onEventErrorComplete()
            }
        })

        viewModel.eventAuthenticated.observe(this, Observer { isAuthenticated ->
            if (isAuthenticated) {
                goToMenu()
                viewModel.onEventAuthenticatedComplete()
            }
        })


    }

    private fun goToForgotPassword() {
        //   findNavController().navigate(LoginFragmentDirections.actionForgotPassword())
        Toast.makeText(this, "goToForgotPassword ", Toast.LENGTH_SHORT).show()
    }

    private fun goToMenu() {
        // Joy para iniciar o fluxo de um outro modulo pelo dynamic delivery
        //  FlowMapper().startMenuFlow(this)
        Toast.makeText(this, "goToMenu ", Toast.LENGTH_SHORT).show()

    }

    private fun showError(errorMessage: String) {
//        NextDialogSingleButton.showDialog(
//            this,
//            NextDialog.Format.ALERT,
//            title,
//            errorMessage,
//            getString(R.string.text_ok),
//            onClickListener
//        )
        Toast.makeText(this, "showError ", Toast.LENGTH_SHORT).show()

    }

}