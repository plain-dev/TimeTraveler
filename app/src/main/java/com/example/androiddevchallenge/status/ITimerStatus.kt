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
package com.example.androiddevchallenge.status

/**
 * 倒计时器状态
 */
interface ITimerStatus {

    /**
     * 开始按钮显示文本, 包括: Start、Pause、Resume.
     */
    fun startButtonDisplayString(): String

    /**
     * 点击开始按钮触发事件
     */
    fun clickStartButton()

    /**
     * 停止按钮开启状态
     */
    fun stopButtonEnabled(): Boolean

    /**
     * 点击停止按钮触发事件
     */
    fun clickStopButton()

    /**
     * 展示或隐藏输入框
     */
    fun showInputText(): Boolean

    /**
     * 进度值
     */
    fun progressSweepAngle(): Float

    /**
     * 倒计时完成文案
     */
    fun completedString(): String
}
