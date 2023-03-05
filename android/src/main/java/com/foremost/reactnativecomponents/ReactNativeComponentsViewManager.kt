package com.foremost.reactnativecomponents

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

@ReactModule(name = ReactNativeComponentsViewManager.NAME)
class ReactNativeComponentsViewManager :
  ReactNativeComponentsViewManagerSpec<ReactNativeComponentsView>() {
  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): ReactNativeComponentsView {
    return ReactNativeComponentsView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: ReactNativeComponentsView?, color: String?) {
    view?.setBackgroundColor(Color.parseColor(color))
  }

  companion object {
    const val NAME = "ReactNativeComponentsView"
  }
}
