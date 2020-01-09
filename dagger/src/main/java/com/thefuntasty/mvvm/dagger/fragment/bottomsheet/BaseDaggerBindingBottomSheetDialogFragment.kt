package com.thefuntasty.mvvm.dagger.fragment.bottomsheet

import android.content.Context
import androidx.databinding.ViewDataBinding
import com.thefuntasty.mvvm.BaseViewModel
import com.thefuntasty.mvvm.ViewState
import com.thefuntasty.mvvm.dagger.inject.TestableAndroidInjection
import com.thefuntasty.mvvm.fragment.bottomsheet.BindingViewModelBottomSheetDialogFragment

abstract class BaseDaggerBindingBottomSheetDialogFragment<VM : BaseViewModel<VS>, VS : ViewState, B : ViewDataBinding> :
    BindingViewModelBottomSheetDialogFragment<VM, VS, B>() {

    override fun onAttach(context: Context) {
        TestableAndroidInjection.inject(this)
        super.onAttach(context)
    }
}
