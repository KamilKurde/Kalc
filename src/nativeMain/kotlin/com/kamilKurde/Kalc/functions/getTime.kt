package com.kamilKurde.kalc.functions

import com.kamilKurde.kalc.units.time.Time
import com.kamilKurde.kalc.units.time.milliseconds
import kotlin.system.getTimeMillis

actual fun getTime(): Time = getTimeMillis().milliseconds