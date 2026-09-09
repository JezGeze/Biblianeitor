package com.jzdevcode.biblianeitor.recyclerView

import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import com.jzdevcode.biblianeitor.R
import android.widget.TextView

class AssosiationsAdapter(private val assosiations: List<String>) : RecyclerView.Adapter<AssosiationsAdapter.AssosiationsViewHolder>() {
    
    //Representa una tarjeta individual del RecyclerView
    class AssosiationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cvListItem: CardView = itemView.findViewById(R.id.cv_list_item)
        val tvBiblicReference: TextView = itemView.findViewById(R.id.tv_biblic_reference)
    }
    
    //Se ejecuta cuando un RecyclerView necesita crear una tarjeta nueva
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AssosiationsViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_recycler_view,parent,false)
        
        return AssosiationsViewHolder(view)
    }
    
    //Se ejecuta para colocar los datos dentro de una tarjeta
    override fun onBindViewHolder(holder: AssosiationsViewHolder, position: Int){
        val titulo = assosiations[position]
        
        holder.tvBiblicReference.text = titulo
        
        holder.cvListItem.setOnClickListener{
            
        }
    }
    
    override fun getItemCount(): Int {
        return assosiations.size
    }
}
