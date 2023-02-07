package io.github.loacq.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "speed_records")
data class SpeedRecord(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    val type: Int,
    val count: Int
)
