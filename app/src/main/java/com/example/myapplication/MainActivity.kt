package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
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


        GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!
            val items = db.TransferenciaDAO().loadAllTransfers()
            if (items.isEmpty()) {
                Log.i("------>", "-----------BBDD buida---------------")
                val call = getRetrofit().create(TransferenciaAPIService::class.java).getAllTransfers().execute()
                val transferencies = call.body() as List<Transferencia>
                val db = AppDatabase.getInstance(applicationContext)
                for (transferencia in transferencies) {
                    Log.i("-->", "--------------------" + transferencia.concepte)
                    db?.TransferenciaDAO()?.insert(transferencia)
                }
            } else {
                Log.i("------>", "-----------BBDD plena---------------")
                items.forEach {
                    Log.i("-->", it.toString())
                }
            }
/*
            val call = getRetrofit().create(TransferenciaAPIService::class.java)
                .getAllTransfers().execute()
            val comments = call.body() as List<Transferencia>
            comments.forEach{
                db.TransferenciaDAO().insert(it)
            }*/
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/MarcGuiu/M07-UF1-API-NCA/")
            .addConverterFactory(GsonConverterFactory.create()) .build()
    }
}