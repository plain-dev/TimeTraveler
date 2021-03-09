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
package com.example.androiddevchallenge.utils

import android.app.Service
import android.media.RingtoneManager
import android.os.Vibrator
import com.example.androiddevchallenge.GlobalApplication

fun togetherReminder() {
    startVibrate(2000L)
    playSound()
}

fun startVibrate(milliseconds: Long = 1000L) {
    val vib = GlobalApplication.context.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
    vib.vibrate(milliseconds)
}

fun playSound() {
    val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val rt = RingtoneManager.getRingtone(GlobalApplication.context, uri)
    rt.play()
}