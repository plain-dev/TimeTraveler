package com.example.androiddevchallenge.status

import com.example.androiddevchallenge.viewmodel.TimerViewModel

/**
 * 未开始状态
 */
class NotStartedStatus(private val viewModel: TimerViewModel) : ITimerStatus {

    override fun startButtonDisplayString() = "Start"

    override fun clickStartButton() = viewModel.animatorController.start()

    override fun stopButtonEnabled() = false

    override fun clickStopButton() {}

    override fun showInputText() = true

    override fun progressSweepAngle() = 0f

    override fun completedString() = ""
}