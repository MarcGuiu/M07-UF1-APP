package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val nom = "nom"
private const val telefon = "telefon"
private const val concepte = "concepte"
private const val import = "import"


class ResumFragment : Fragment(){
    // TODO: Rename and change types of parameters
    private var nom: String? = null
    private var telefon: String? = null
    private var concepte: String? = null
    private var import: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nom = it.getString(nom)
            telefon = it.getString(telefon)
            concepte = it.getString(concepte)
            import = it.getString(import)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resum, container, false)
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nomResum = view.findViewById<TextView>(R.id.nomResum)
        val concepteResum = view.findViewById<TextView>(R.id.concepteResum)
        val telefonResum = view.findViewById<TextView>(R.id.telefonResum)
        val importResum = view.findViewById<TextView>(R.id.importResum)
        //val bundle = arguments
        //val newTransfer = bundle?.getParcelable<Transferencia>("miObjeto")
        /*
        val telefon = newTransfer?.telefon.toString()
        val concepte = newTransfer?.concept
        val import = newTransfer?.importDiners.toString()
         */

        nomResum.text = "Nom: $nom"
        telefonResum.text = "Telefon: $telefon"
        concepteResum.text = "Concepte: $concepte"
        importResum.text = "Import: $import"
    }

    companion object {

    }
}