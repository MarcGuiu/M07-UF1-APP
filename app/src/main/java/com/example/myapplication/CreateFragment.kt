package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateFragment : Fragment() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = view.findViewById<EditText>(R.id.id)
        val concepte = view.findViewById<EditText>(R.id.concepte)
        val importDiners = view.findViewById<EditText>(R.id.importDiners)
        val telefon = view.findViewById<EditText>(R.id.telefon)
        val transferir = view.findViewById<Button>(R.id.transferir)

        transferir.setOnClickListener {
            GlobalScope.launch {
                db = AppDatabase.getInstance(requireContext())!!
                val transferencia = Transferencia(
                    id.text.toString().toInt(),
                    concepte.text.toString(),
                    importDiners.text.toString().toInt(),
                    telefon.text.toString().toInt()
                )
                db.TransferenciaDAO().insert(transferencia)

                activity?.runOnUiThread {
                    // Finaliza la actividad actual
                    activity?.finish()
                    // Inicia la actividad Pagina2
                    val intent = Intent(context, Pagina2::class.java)
                    startActivity(intent)
                }

            }

        }

    }

    companion object {

    }
}