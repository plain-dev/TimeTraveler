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
package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.constant.MAX_INPUT_LENGTH
import com.example.androiddevchallenge.controller.AnimatorController
import com.example.androiddevchallenge.status.CompletedStatus
import com.example.androiddevchallenge.status.ITimerStatus
import com.example.androiddevchallenge.status.NotStartedStatus

/**
 * 倒计时 [ViewModel]
 */
class TimerViewModel : ViewModel() {

    /**
     * 用户设置总时间, 单位: 秒
     */
    var totalTime: Long by mutableStateOf(0)

    /**
     * 剩余时间, 单位: 秒
     */
    var timeLeft: Long by mutableStateOf(0)

    /**
     * 动画进度值
     */
    var animValue: Float by mutableStateOf(0.0f)

    /**
     * 计时器状态
     */
    var status: ITimerStatus by mutableStateOf(NotStartedStatus(this))

    var animatorController = AnimatorController(this)

    /**
     * 更新数据 [inputValue]
     *
     * @see [TimerViewModel](https://github.com/wkxjc/CountdownTimer/blob/main/app/src/main/java/com/example/androiddevchallenge/model/TimerViewModel.kt)
     */
    fun updateValue(inputValue: String) {
        if (inputValue.length > MAX_INPUT_LENGTH) return
        var value = inputValue.replace("\\D".toRegex(), "")
        if (value.startsWith("0")) value = value.substring(1)
        if (value.isBlank()) value = "0"
        totalTime = value.toLong()
        timeLeft = value.toLong()
        if (status is CompletedStatus) status = NotStartedStatus(this)
    }
}
