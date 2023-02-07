package io.github.loacq.data.room

import androidx.room.TypeConverter
import java.time.LocalTime

class Converters {
    @TypeConverter
    fun localTimeToDatestamp(localTime: LocalTime): Long = localTime.toNanoOfDay()

    @TypeConverter
    fun datestampToLocalTime(value: Long): LocalTime = LocalTime.ofNanoOfDay(value)
}
