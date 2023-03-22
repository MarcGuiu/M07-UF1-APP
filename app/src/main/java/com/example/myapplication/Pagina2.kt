package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.widget.SearchView

class Pagina2 : AppCompatActivity() {

    private val items: ArrayList<Transferencia> = ArrayList()
    private lateinit var db: AppDatabase
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private lateinit var adapter: ListAdapter


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
        searchView = findViewById(R.id.searchView)
        val query = searchView.query.toString()


        if (username != null){
            var aux = "Benvingut, $username!"
            benvingut.text = aux
        }

        if (dinersTotal == null) {
            dinersTotal = "1000"
        }

        money.text = dinersTotal.toString()

        GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!
            val transferencies = db.TransferenciaDAO().loadAllTransfers()
            if (!transferencies.isEmpty()) {
                transferencies.forEach{
                    items.add(it)
                }
            }

        }
        adapter = ListAdapter(items, this)
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
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Acciones al pulsar el botón de búsqueda
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    val filteredList = items.filter { it.concept?.contains(newText, ignoreCase = true)
                        ?: true }
                    adapter.updateList(filteredList)
                } else {
                    adapter.updateList(items)
                }
                return true
            }
        })
    }
}