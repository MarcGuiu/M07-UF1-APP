package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface TransferenciaDAO {
    @Insert(onConflict = REPLACE)
    fun insert(transferencia: Transferencia)

    @Query("SELECT * FROM item")
    fun loadAllTransfers(): List<Transferencia>
}