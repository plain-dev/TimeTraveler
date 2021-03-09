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
package com.example.androiddevchallenge.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.StartButton
import com.example.androiddevchallenge.ui.common.StopButton
import com.example.androiddevchallenge.ui.common.TimeInput
import com.example.androiddevchallenge.ui.common.Title
import com.example.androiddevchallenge.ui.progress.CircleProgress
import com.example.androiddevchallenge.utils.toTimeContent
import com.example.androiddevchallenge.viewmodel.TimerViewModel

@Composable
fun TimeTraveler(timerViewModel: TimerViewModel) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Title()
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 100.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                CircleProgress(
                    progress = timerViewModel.status.progressSweepAngle(),
                    strokeWidth = 10.dp,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    fontWeight = FontWeight.Bold,
                    text = timerViewModel.timeLeft.toTimeContent(),
                    fontSize = 30.sp,
                    color = colorResource(id = R.color.text_color),
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                StartButton(viewModel = timerViewModel)
                StopButton(viewModel = timerViewModel)
            }
            Spacer(modifier = Modifier.height(10.dp))
            TimeInput(viewModel = timerViewModel)
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                text = "@Plain",
                fontSize = 12.sp,
                color = colorResource(id = R.color.text_color),
            )
        }
    }
}
