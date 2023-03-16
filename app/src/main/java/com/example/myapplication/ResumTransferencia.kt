package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class resumTransferencia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resum_transferencia)

        val nomResum = findViewById<TextView>(R.id.nomResum)
        val telefonResum = findViewById<TextView>(R.id.telefonResum)
        val concepteResum = findViewById<TextView>(R.id.concepteResum)
        val importResum = findViewById<TextView>(R.id.importResum)
        val btnReturn = findViewById<Button>(R.id.btnRetorn)
        val username = intent.getStringExtra("username")
        val nom = intent.getStringExtra("nom")
        val telefon = intent.getStringExtra("telefon")
        val concepte = intent.getStringExtra("concepte")

        val import = intent.getStringExtra("import")
        val dinersTotal = intent.getStringExtra("dinersTotal")

        nomResum.text = "Nom: $nom"
        telefonResum.text = "Telefon: $telefon"
        concepteResum.text = "Concepte: $concepte"
        importResum.text = "Import: $import"

        btnReturn.setOnClickListener{
            val transf = Tranferencies(nom.toString(), telefon.toString().toInt(), concepte.toString(), import.toString().toFloat())
            val intent = Intent(applicationContext, Pagina2::class.java)
            intent.apply {
                putExtra("username", username)
                putExtra("import", import)
                putExtra("dinersTotal", dinersTotal)
                putExtra("transferenciaNova", transf)
            }
            startActivity(intent)
        }
    }
}