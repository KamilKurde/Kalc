package com.github.KamilKurde.Kalc.functions

import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.time.milliseconds
import kotlin.js.Date

actual fun getTime(): Time = Date().getMilliseconds().milliseconds