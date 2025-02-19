// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.openapi.wm.impl

import com.intellij.openapi.application.impl.RawSwingDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal abstract class SimpleAnimator {
  // frame - in 1..totalFrames
  abstract fun paintNow(frame: Int, totalFrames: Int)

  protected open fun paintCycleStart() {}

  suspend fun run(totalFrames: Int, cycleDuration: Long) {
    val duration = cycleDuration / totalFrames
    // kotlin delays has only millisecond precision
    val startTime = System.currentTimeMillis()
    withContext(RawSwingDispatcher) {
      paintCycleStart()
      var currentFrame = 0
      while (true) {
        val cycleTime = System.currentTimeMillis() - startTime
        if (cycleTime <= 0) {
          break
        }

        val newFrame = ((cycleTime * totalFrames) / cycleDuration).toInt().coerceAtMost(totalFrames)
        if (newFrame == currentFrame) {
          continue
        }

        // paint all frames including those that were not rendered in time
        for (frame in (currentFrame + 1)..newFrame) {
          paintNow(frame, totalFrames)
        }

        if (newFrame == totalFrames) {
          break
        }

        currentFrame = newFrame

        delay(duration)
      }
    }
  }
}
