package com.example.uber2.fragmentos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uber2.modelo.Item
import com.example.uber2.R
import com.example.uber2.modelo.DespensaFirebase
import kotlinx.android.synthetic.main.*


class DespensaRecyclerAdapter( private val list: List<Item>)
    : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

}

class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.renglon_item, parent, false)) {
    private var cantidadItemTextView: TextView? = null
    private var itemDescripcionTextView: TextView? = null
    private var cantidadEditValue: EditText? = null
    private var descripcionEditValue: EditText? = null
    private var borrarBtn: Button? = null
    private var modificarBtn: Button? = null


    init {
        cantidadItemTextView = itemView.findViewById(R.id.item_cantidad)
        itemDescripcionTextView = itemView.findViewById(R.id.item_descipcion)
        cantidadEditValue = itemView.findViewById(R.id.cantidadEdit)
        descripcionEditValue = itemView.findViewById(R.id.descripcionEdit)
        borrarBtn = itemView.findViewById(R.id.borrarUnoButton)
        modificarBtn = itemView.findViewById(R.id.ModificarButton)
    }

    fun bind(item: Item) {
        cantidadItemTextView?.text = item.cantidad.toString()
        itemDescripcionTextView?.text = item.descripcion
        borrarBtn?.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            val toDelete = Item()
            toDelete.id = item.id
            toDelete.cantidad = 0
            toDelete.descripcion = ""
            despensaFirebase.borraUnItem(toDelete)
        }
        modificarBtn?.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            val toModify = Item()
            toModify.id = item.id
            if(cantidadEditValue?.text.toString()!=""){
                toModify.cantidad= cantidadEditValue?.text.toString().toInt()
            }else{
                toModify.cantidad = item.cantidad
            }

            if(descripcionEditValue?.text.toString()!=""){
                toModify.descripcion = descripcionEditValue?.text.toString()
            }else {
                toModify.descripcion = item.descripcion
            }
            despensaFirebase.modificaUnItem(toModify)
        }

    }
}