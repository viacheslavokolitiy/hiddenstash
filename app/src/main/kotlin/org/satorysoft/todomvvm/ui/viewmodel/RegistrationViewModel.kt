package org.satorysoft.todomvvm.ui.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import org.satorysoft.todomvvm.BR

/**
 * Created by viacheslavokolitiy on 18.09.2016.
 */
class RegistrationViewModel : BaseObservable() {

    @Bindable
    private var formValid: ObservableBoolean = ObservableBoolean(false)

    fun isFormValid(): ObservableBoolean {
        return formValid
    }

    fun setFormValid(formValid: ObservableBoolean) {
        this.formValid = formValid
        notifyPropertyChanged(BR.formValid)
    }
}