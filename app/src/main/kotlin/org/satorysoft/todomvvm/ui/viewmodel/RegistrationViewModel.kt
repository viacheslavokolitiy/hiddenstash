package org.satorysoft.todomvvm.ui.viewmodel

import android.databinding.*
import org.satorysoft.todomvvm.BR

/**
 * Created by viacheslavokolitiy on 18.09.2016.
 */
class RegistrationViewModel : BaseObservable() {

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
}