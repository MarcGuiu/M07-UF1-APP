package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transferencia (
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "concepte") var concepte: String?,
    @ColumnInfo(name = "import") var importDiners: Int?,
    @ColumnInfo(name = "telefon") var telefon: String?
)