package org.satorysoft.todomvvm.ui.viewmodel

import android.content.Context
import android.content.Intent
import android.databinding.*
import android.provider.Settings.Secure
import android.text.TextUtils
import org.satorysoft.todomvvm.BR
import org.satorysoft.todomvvm.ui.misc.HashCreator

/**
 * Created by viacheslavokolitiy on 18.09.2016.
 */
class RegistrationViewModel(private val context: Context) : BaseObservable() {

    @Bindable
    private var userEmailValid: ObservableBoolean = ObservableBoolean(false)

    @Bindable
    private var userPasswordValid: ObservableBoolean = ObservableBoolean(false)

    fun getUserEmailValid(): ObservableBoolean {
        return userEmailValid
    }

    fun getUserPasswordValid(): ObservableBoolean {
        return userPasswordValid
    }

    fun setUserEmailValid(userEmailValid: ObservableBoolean) {
        this.userEmailValid = userEmailValid
        notifyPropertyChanged(BR.userEmailValid)
    }

    fun setUserPasswordValid(userPasswordValid: ObservableBoolean){
        this.userPasswordValid = userPasswordValid
        notifyPropertyChanged(BR.userPasswordValid)
    }

    fun createUserId(userEmail: String, userPassword: String): String {
        val deviceId: String = Secure.getString(context.contentResolver,
                Secure.ANDROID_ID)
        val userData = userEmail.plus(":").plus(userPassword).plus(":").plus(deviceId)
        val userHash = HashCreator().createSHA256Hash(userData)

        return userHash
    }
}