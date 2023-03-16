package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class Transferencia (@SerializedName("id") var id:Int,
                            @SerializedName("concept") var concepte:String,
                            @SerializedName("import") var import: Int,
                            @SerializedName("telefon") var telefon: String)