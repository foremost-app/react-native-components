package com.foremost.reactnativecomponents

import android.content.Context
import android.util.AttributeSet
import android.view.View

class ReactNativeComponentsView : View {
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )
}
