package com.github.ihoyong.mvvmexample.utils.extension

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


inline fun <reified VM : ViewModel> AppCompatActivity.viewModelProvider(
        provider: ViewModelProvider.Factory
) =
        ViewModelProviders.of(this, provider).get(VM::class.java)

fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}