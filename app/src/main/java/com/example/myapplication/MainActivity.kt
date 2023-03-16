package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username =findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btn = findViewById<Button>(R.id.button)


        btn.setOnClickListener {
            if (username.text.isEmpty() || password.text.isEmpty()) {
                val text = "Nom i usuari obligatoris";
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {
                val intent = Intent(applicationContext, Pagina2::class.java)
                intent.apply {
                    putExtra("username", username.text.toString())
                }
                startActivity(intent)
            }
        }



    }
}