package com.thefuntasty.mvvmsample.ui.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.thefuntasty.mvvmsample.databinding.ActivityFormBinding
import com.thefuntasty.mvvmsample.ui.ShowToastEvent
import com.thefuntasty.mvvmsample.ui.base.BaseActivity
import javax.inject.Inject

class FormActivity : BaseActivity<FormViewModel, ActivityFormBinding>(), FormView {

    @Inject lateinit var viewModelFactory: FormViewModelFactory

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, FormActivity::class.java)
    }

    override fun createViewModel(): FormViewModel = getViewModelFromProvider(viewModelFactory)

    override fun inflateBindingLayout(layoutInflater: LayoutInflater): ActivityFormBinding? =
            ActivityFormBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observerEvent(ShowToastEvent::class) {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        }
    }
}