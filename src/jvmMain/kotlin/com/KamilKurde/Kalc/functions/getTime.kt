package com.kamilKurde.kalc.functions

import com.kamilKurde.kalc.units.time.Time
import com.kamilKurde.kalc.units.time.milliseconds
import java.lang.System.currentTimeMillis

actual fun getTime(): Time = currentTimeMillis().milliseconds