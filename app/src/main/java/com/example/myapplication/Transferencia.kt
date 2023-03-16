package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transferencia (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "concept") var concept: String?,
    @ColumnInfo(name = "import") var import: Int,
    @ColumnInfo(name = "telefon") var telefon: String
)
