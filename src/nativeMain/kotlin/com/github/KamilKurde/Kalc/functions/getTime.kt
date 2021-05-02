package com.github.KamilKurde.Kalc.functions

import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.time.milliseconds
import kotlin.system.getTimeMillis

actual fun getTime(): Time = getTimeMillis().milliseconds