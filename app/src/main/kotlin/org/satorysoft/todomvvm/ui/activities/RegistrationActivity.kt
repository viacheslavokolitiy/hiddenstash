package org.satorysoft.todomvvm.ui.activities

import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxTextView
import org.satorysoft.todomvvm.BR
import org.satorysoft.todomvvm.R
import org.satorysoft.todomvvm.databinding.ActivityRegistrationBinding
import org.satorysoft.todomvvm.ui.viewmodel.RegistrationViewModel
import rx.Observable
import rx.functions.Func2

/**
 * Created by viacheslavokolitiy on 18.09.2016.
 */
class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    lateinit var registrationViewModel: RegistrationViewModel

    lateinit var userEmailInput: EditText
    lateinit var userPasswordInput: EditText
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        registrationViewModel = RegistrationViewModel(this)

        binding.setVariable(BR.registrationViewModel, registrationViewModel)

        userEmailInput = binding.edtUserEmail
        userPasswordInput = binding.edtUserPassword
        submitButton = binding.btnRegister
    }

    override fun onStart() {
        super.onStart()

        RxTextView.textChanges(userEmailInput)
                .filter { email -> email.length > 2 }
                .subscribe { subscriber ->  validateInput(userEmailInput.text.toString())}

        RxTextView.textChanges(userPasswordInput)
                .filter { password -> password.length > 2 }
                .subscribe { subscriber -> validateUserPassword(userPasswordInput.text.toString()) }

        RxView.clicks(submitButton).subscribe { subscriber -> createUser(userEmailInput.text.toString(),
                userPasswordInput.text.toString()) }
    }

    private fun createUser(userEmail: String, userPassword: String) {
        registrationViewModel.createUserId(userEmail, userPassword);
    }

    private fun validateUserPassword(userPassword: String) {
        registrationViewModel.setUserPasswordValid(ObservableBoolean(userPassword.length > 6))
    }

    private fun validateInput(userEmail: String) {
        registrationViewModel.setUserEmailValid(ObservableBoolean(userEmail.contains("@")))
    }
}