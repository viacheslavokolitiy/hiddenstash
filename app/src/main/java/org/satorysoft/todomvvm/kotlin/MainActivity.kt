package org.satorysoft.todomvvm.kotlin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.satorysoft.todomvvm.kotlin.databinding.ActivityMainBinding
import org.satorysoft.todomvvm.kotlin.ui.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityViewModel = MainActivityViewModel()

        binding.setVariable(BR.viewModel, mainActivityViewModel)
    }
}
