package com.jzdevcode.biblianeitor.recyclerView

import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import com.jzdevcode.biblianeitor.R
import android.widget.TextView
import android.content.Context
import androidx.appcompat.app.AlertDialog

/*class AssosiationsAdapter(private val context: Context,
                          private val titles: List<String>,
                          private val assosiations: List<String>,
                          private val biblicReferences: List<String>,
                          private val onClick: (String) -> Unit
                         ) : RecyclerView.Adapter<AssosiationsAdapter.AssosiationsViewHolder>() {*/
class AssosiationsAdapter(//private val context: Context,
                          private val titles: List<String>,
                          private var onClick: (Int) -> Unit
                         ) : RecyclerView.Adapter<AssosiationsAdapter.AssosiationsViewHolder>() {
                         
    
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
        val title = titles[position]
        //val assosiation = assosiations[position]
        //val biblicReference = biblicReferences[position]
        
        holder.tvBiblicReference.text = title
        
        holder.cvListItem.setOnClickListener{
            val index = holder.bindingAdapterPosition
            if(position != RecyclerView.NO_POSITION){
                onClick(position)
            }
        }
        
        /*holder.cvListItem.setOnClickListener{
            AlertDialog.Builder(context)
            .setTitle("Asosiación de $title")
            .setMessage("Asociación: $assosiation \nTexto: $biblicReference")
            .setPositiveButton("Cerrar", null)
            .show()
        }*/
    }
    
    override fun getItemCount(): Int {
        return titles.size
    }
}
