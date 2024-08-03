package com.jordicuevas.medifinderapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jordicuevas.medifinderapp.data.remote.model.MedicineSearch
import com.jordicuevas.medifinderapp.databinding.SearchElementBinding

class SearchAdapter (
    private var resultados: List<MedicineSearch>,
    private var onAddBtnClicked: (MedicineSearch) -> Unit) :
    RecyclerView.Adapter<SearchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int = resultados.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val result = resultados[position]

        holder.bind(result)

        holder.ibAddElement.setOnClickListener{
            onAddBtnClicked(result)
            holder.ibAddElement.setEnabled(false)
        }

    }

}