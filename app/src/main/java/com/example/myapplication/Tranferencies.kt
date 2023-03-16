package com.example.myapplication

import java.io.Serializable

class Tranferencies(
    var nom: String,
    var telefon: Int,
    var concepte: String,
    var importTranferencia: Float



):Serializable {
    override fun toString(): String {
        return "Nom='$nom',         Import=$importTranferencia"
    }
}