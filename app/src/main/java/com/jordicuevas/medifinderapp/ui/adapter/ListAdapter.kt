package com.jordicuevas.medifinderapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jordicuevas.medifinderapp.data.remote.model.Medicine
import com.jordicuevas.medifinderapp.data.remote.model.MedicineDetail
import com.jordicuevas.medifinderapp.databinding.MedicineElementBinding

class ListAdapter(
    private val listaMeds: List<Medicine>,
    private val listaDetails: List<MedicineDetail>,
    private val onListClicked: (MedicineDetail) -> Unit):
    RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = MedicineElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listaMeds.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val med = listaMeds[position]
        val det = listaDetails[position]

        holder.bind(med)

//        Glide.with(holder.itemView.context)
//            .load(perro.thumbnail)
//            .into(holder.ivThumbnail)

        holder.itemView.setOnClickListener{
            onListClicked(det)
        }

    }


}