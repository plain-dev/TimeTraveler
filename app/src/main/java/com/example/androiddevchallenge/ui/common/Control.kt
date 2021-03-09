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
package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.viewmodel.TimerViewModel

@Composable
fun StartButton(viewModel: TimerViewModel) {
    Button(
        modifier = Modifier
            .width(150.dp)
            .padding(16.dp),
        enabled = viewModel.totalTime > 0,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.btn_bg_color),
            contentColor = colorResource(id = R.color.btn_text_color),
            disabledBackgroundColor = colorResource(id = R.color.btn_disabled_bg_color),
            disabledContentColor = colorResource(id = R.color.btn_disabled_text_color)
        ),
        onClick = viewModel.status::clickStartButton,
    ) {
        Text(text = viewModel.status.startButtonDisplayString())
    }
}

@Composable
fun StopButton(viewModel: TimerViewModel) {
    Button(
        modifier = Modifier
            .width(150.dp)
            .padding(16.dp),
        enabled = viewModel.status.stopButtonEnabled(),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.btn_bg_color),
            contentColor = colorResource(id = R.color.btn_text_color),
            disabledBackgroundColor = colorResource(id = R.color.btn_disabled_bg_color),
            disabledContentColor = colorResource(id = R.color.btn_disabled_text_color)
        ),
        onClick = viewModel.status::clickStopButton
    ) {
        Text(text = "Stop")
    }
}
