package com.kamilKurde.kalc.functions

import com.kamilKurde.kalc.units.time.Time
import com.kamilKurde.kalc.units.time.milliseconds
import kotlin.js.Date

actual fun getTime(): Time = Date().getMilliseconds().milliseconds