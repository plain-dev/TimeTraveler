/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.controller

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import com.example.androiddevchallenge.constant.ANIMATOR_SPEED
import com.example.androiddevchallenge.status.CompletedStatus
import com.example.androiddevchallenge.status.NotStartedStatus
import com.example.androiddevchallenge.status.PausedStatus
import com.example.androiddevchallenge.status.StartedStatus
import com.example.androiddevchallenge.utils.togetherReminder
import com.example.androiddevchallenge.viewmodel.TimerViewModel
import kotlin.math.ceil

class AnimatorController(private val viewModel: TimerViewModel) {

    private var valueAnimator: ValueAnimator? = null

    fun start() {
        if (viewModel.totalTime == 0L) return
        if (valueAnimator == null) {
            valueAnimator = ValueAnimator.ofInt(viewModel.totalTime.toInt() * ANIMATOR_SPEED, 0)
            valueAnimator?.interpolator = LinearInterpolator()
            valueAnimator?.addUpdateListener {
                (it.animatedValue as Int / ANIMATOR_SPEED.toFloat()).let { currentValue ->
                    viewModel.animValue = currentValue
                    viewModel.timeLeft = ceil(currentValue).toLong()
                }
            }
            valueAnimator?.addListener(object : AnimatorListenerAdapter() {

                var isCancel = false

                override fun onAnimationCancel(animation: Animator?) {
                    isCancel = true
                    super.onAnimationCancel(animation)
                }

                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    if (!isCancel) {
                        complete()
                    }
                    isCancel = false
                }
            })
        } else {
            valueAnimator?.setIntValues(viewModel.totalTime.toInt() * ANIMATOR_SPEED, 0)
        }
        // 间隔1秒
        valueAnimator?.duration = viewModel.totalTime * 1000L
        valueAnimator?.start()
        viewModel.status = StartedStatus(viewModel)
    }

    fun pause() {
        valueAnimator?.pause()
        viewModel.status = PausedStatus(viewModel)
    }

    fun resume() {
        valueAnimator?.resume()
        viewModel.status = StartedStatus(viewModel)
    }

    fun stop() {
        valueAnimator?.cancel()
        viewModel.timeLeft = 0
        viewModel.status = NotStartedStatus(viewModel)
    }

    fun complete() {
        viewModel.totalTime = 0
        viewModel.status = CompletedStatus(viewModel)
        togetherReminder()
    }
}
