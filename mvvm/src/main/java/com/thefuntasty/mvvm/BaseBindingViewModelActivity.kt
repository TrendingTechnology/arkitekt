package com.thefuntasty.mvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import com.thefuntasty.mvvm.event.Event
import com.thefuntasty.mvvm.factory.BaseViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlin.reflect.KClass

abstract class BaseBindingViewModelActivity<VM : BaseViewModel, B : ViewDataBinding> :
        DaggerAppCompatActivity(), BaseView {

    lateinit var viewModel: VM
    lateinit var binding: B

    abstract fun createViewModel(): VM

    abstract fun inflateBindingLayout(layoutInflater: LayoutInflater): B?

    protected fun getViewModelFromProvider(factory: BaseViewModelFactory<VM>, viewModelKClass: KClass<VM>): VM {
        return ViewModelProviders.of(this, factory).get(viewModelKClass.java)
    }

    protected fun <T : Event> observerEvent(event: KClass<T>, observer: (T) -> Unit) {
        viewModel.observeEvent(this, event, observer)
    }
}
