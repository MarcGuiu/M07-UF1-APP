    package com.example.myapplication

    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Button
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView

    class ListAdapter(val items: ArrayList<Tranferencies>, val context: Context): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.tvItem.text = item.nom
            holder.tvItem2.text = item.importTranferencia.toString() + " €"

            holder.btn2.setOnClickListener(){
                items.removeAt(position)
                notifyDataSetChanged()
            }
        }

        override fun getItemCount(): Int {
            return items.size
        }

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val tvItem = view.findViewById<TextView>(R.id.tv_item)
            val tvItem2 = view.findViewById<TextView>(R.id.tv_item2)
            val btn2 = view.findViewById<Button>(R.id.button7)
        }
    }