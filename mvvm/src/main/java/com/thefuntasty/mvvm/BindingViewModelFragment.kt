package com.thefuntasty.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.thefuntasty.mvvm.binding.BindingFragmentDelegate
import com.thefuntasty.mvvm.binding.BindingVariables

abstract class BindingViewModelFragment<VM : BaseViewModel<VS>, VS : ViewState, B : ViewDataBinding>
    : ViewModelFragment<VM, VS>() {

    private val bindingFragmentDelegate = BindingFragmentDelegate<VS, B>()

    abstract val brViewVariableId: Int
    abstract val brViewModelVariableId: Int
    abstract val brViewStateVariableId: Int

    lateinit var binding: B

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return bindingFragmentDelegate.initViewBinding(
            this,
            viewModel,
            inflater,
            container,
            layoutResId,
            getBindingVariables()
        ).let {
            binding = it.first
            return@let it.second
        }
    }

    private fun getBindingVariables(): BindingVariables {
        return BindingVariables(brViewVariableId, brViewModelVariableId, brViewStateVariableId)
    }
}
