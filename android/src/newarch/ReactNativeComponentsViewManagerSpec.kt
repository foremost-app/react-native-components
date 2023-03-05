package com.foremost.reactnativecomponents

import android.view.View

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.viewmanagers.ReactNativeComponentsViewManagerDelegate
import com.facebook.react.viewmanagers.ReactNativeComponentsViewManagerInterface
import com.facebook.soloader.SoLoader

abstract class ReactNativeComponentsViewManagerSpec<T : View> : SimpleViewManager<T>(), ReactNativeComponentsViewManagerInterface<T> {
  private val mDelegate: ViewManagerDelegate<T>

  init {
    mDelegate = ReactNativeComponentsViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<T>? {
    return mDelegate
  }

  companion object {
    init {
      if (BuildConfig.CODEGEN_MODULE_REGISTRATION != null) {
        SoLoader.loadLibrary(BuildConfig.CODEGEN_MODULE_REGISTRATION)
      }
    }
  }
}
