package com.github.KamilKurde.Kalc.functions

import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.time.milliseconds
import java.lang.System.currentTimeMillis

actual fun getTime(): Time = currentTimeMillis().milliseconds