package org.satorysoft.todomvvm.ui.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.preference.PreferenceManager
import android.text.TextUtils

/**
 * Created by viacheslavokolitiy on 18.09.2016.
 */
class MainActivityViewModel(private val context: Context) : BaseObservable(){

    internal fun isTokenExists(token: String) : Boolean {
        return TextUtils.isEmpty(PreferenceManager.getDefaultSharedPreferences(context).getString(token, null))
    }
}