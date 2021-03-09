package com.example.androiddevchallenge.status

import com.example.androiddevchallenge.viewmodel.TimerViewModel

/**
 * 暂停状态
 */
class PausedStatus(private val viewModel: TimerViewModel) : ITimerStatus {
    override fun startButtonDisplayString() = "Resume"

    override fun clickStartButton() = viewModel.animatorController.resume()

    override fun stopButtonEnabled() = true

    override fun clickStopButton() = viewModel.animatorController.stop()

    override fun showInputText() = false

    override fun progressSweepAngle() = viewModel.animValue / viewModel.totalTime

    override fun completedString() = ""
}