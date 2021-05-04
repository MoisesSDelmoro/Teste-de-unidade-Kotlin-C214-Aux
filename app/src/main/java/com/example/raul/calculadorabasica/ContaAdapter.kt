package com.example.raul.calculadorabasica

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.conta_list_item.view.*

// fonte: https://medium.com/collabcode/criando-lista-com-recyclerview-no-android-com-kotlin-85cb76f3775d
class ContaAdapter(val itens: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.conta_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.let {
            it.conta.text = itens.get(position)
        }
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val conta = view.tv_conta
}
