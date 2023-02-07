package io.github.loacq.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = "time_records")
data class TimeRecord(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    val type: Int,
    val starTime: LocalTime,
    val endTime: LocalTime
)

fun TimeRecord.diffTime(): LocalTime {
    return LocalTime.ofNanoOfDay(endTime.toNanoOfDay() - starTime.toNanoOfDay())
}
