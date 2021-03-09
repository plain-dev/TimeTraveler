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