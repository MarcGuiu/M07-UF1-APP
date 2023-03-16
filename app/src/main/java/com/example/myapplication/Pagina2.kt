package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class Pagina2 : AppCompatActivity() {

    private val items: ArrayList<Tranferencies> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina2)

        val username = intent.getStringExtra("username")
        var benvingut = findViewById<TextView>(R.id.benvingut)
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val transfer = findViewById<Button>(R.id.transfer)
        var money = findViewById<TextView>(R.id.money)
        var import = intent.getStringExtra("import")
        var dinersTotal = intent.getStringExtra("dinersTotal")

        if (username != null){
            var aux = "Benvingut, $username!"
            benvingut.text = aux
        }

        if (dinersTotal == null) {
            dinersTotal = "1000"
        }

        money.text = dinersTotal.toString()
        if (import != null){
            var importInt = import.toInt()
            var result = (dinersTotal?.toInt() ?: 1000) - importInt
            money.text = result.toString()
            dinersTotal = result.toString()

            var transf = intent.getSerializableExtra("transferenciaNova") as Tranferencies
            items.add(transf)
        }

        val transf1 = Tranferencies("Trans1", 123456789, "Bizum", 100.00F)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        items.add(transf1)
        rvList.adapter = ListAdapter(items, this)
        rvList.layoutManager = LinearLayoutManager(this)

        transfer.setOnClickListener{
            val intent = Intent(applicationContext, NovaTransferencia::class.java)
            intent.apply {
                putExtra("username", username)
                putExtra("dinersTotal", dinersTotal)
            }
            startActivity(intent)
        }
    }
}