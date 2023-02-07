package io.github.loacq.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TimeRecordDao {
    // Get all records
    @Query("SELECT * FROM time_records ORDER BY id DESC")
    suspend fun getAllRecords(): List<TimeRecord>

    // Put record
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: TimeRecord)
}
