package com.example.androiddevchallenge.status

import com.example.androiddevchallenge.viewmodel.TimerViewModel

/**
 * 开始状态
 */
class StartedStatus(private val viewModel: TimerViewModel) : ITimerStatus {
    override fun startButtonDisplayString() = "Pause"

    override fun clickStartButton() = viewModel.animatorController.pause()

    override fun stopButtonEnabled() = true

    override fun clickStopButton() = viewModel.animatorController.stop()

    override fun showInputText() = false

    override fun progressSweepAngle() = viewModel.animValue / viewModel.totalTime

    override fun completedString() = ""
}