package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NovaTransferencia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_transferencia)

        val nom = findViewById<EditText>(R.id.nom)
        val telefon = findViewById<EditText>(R.id.telefon)
        val concepte = findViewById<EditText>(R.id.concepte)
        val import = findViewById<EditText>(R.id.importDiners)
        val transferir = findViewById<Button>(R.id.transferir)
        val username = intent.getStringExtra("username")
        val dinersTotal = intent.getStringExtra("dinersTotal")

        transferir.setOnClickListener {
            if (nom.text.isEmpty() || telefon.text.isEmpty() || concepte.text.isEmpty() || import.text.isEmpty()) {
                val text = "Tots els camps son obligatoris";
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {
                val intent = Intent(applicationContext, resumTransferencia::class.java)
                intent.apply {
                    putExtra("nom", nom.text.toString())
                    putExtra("telefon", telefon.text.toString())
                    putExtra("concepte", concepte.text.toString())
                    putExtra("import", import.text.toString())
                    putExtra("username", username)
                    putExtra("dinersTotal", dinersTotal)


                }
                startActivity(intent)
            }


        }





    }
}