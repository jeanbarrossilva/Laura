package com.jeanbarrossilva.laurafoundation.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jeanbarrossilva.laurafoundation.data.Acquisition

@Dao
interface AcquisitionDao {
    @Query("SELECT * FROM acquisitions")
    fun all(): LiveData<List<Acquisition>>

    @Insert
    fun add(acquisition: Acquisition)

    @Delete
    fun remove(acquisition: Acquisition)
}