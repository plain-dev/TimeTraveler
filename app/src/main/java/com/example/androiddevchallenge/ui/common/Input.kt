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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.toast
import com.example.androiddevchallenge.viewmodel.TimerViewModel

/**
 * 倒计时输入组件
 *
 * @author Plain
 */

@Composable
fun TimeInput(viewModel: TimerViewModel) {
    val focusManager = LocalFocusManager.current
    Box(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 60.dp),
        contentAlignment = Alignment.Center
    ) {
        if (viewModel.status.showInputText()) {
            OutlinedTextField(
                modifier = Modifier.fillMaxSize(),
                value = if (viewModel.totalTime == 0L) "" else viewModel.totalTime.toString(),
                onValueChange = viewModel::updateValue,
                placeholder = {
                    Text(
                        text = "INPUT START (S)",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.btn_disabled_text_color),
                    )
                },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    textColor = colorResource(id = R.color.text_color),
                    cursorColor = colorResource(id = R.color.btn_text_color),
                    focusedIndicatorColor = colorResource(id = R.color.btn_text_color)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        "Click `Start` to start the countdown.".toast()
                        // 收回键盘
                        focusManager.clearFocus()
                    }
                )
            )
        }
    }
}
