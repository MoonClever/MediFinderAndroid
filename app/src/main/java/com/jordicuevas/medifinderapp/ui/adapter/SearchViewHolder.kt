package com.jordicuevas.medifinderapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.jordicuevas.medifinderapp.data.remote.model.MedicineSearch
import com.jordicuevas.medifinderapp.databinding.SearchElementBinding

class SearchViewHolder (private var binding: SearchElementBinding):
    RecyclerView.ViewHolder(binding.root){
        val ibAddElement = binding.ibAddMed

        fun bind(searchElem: MedicineSearch){
            binding.tvGenName.text = searchElem.genName
            binding.tvBrandName.text =searchElem.branName
            binding.tvRoute.text = searchElem.route
            binding.tvManufacturer.text = searchElem.manufacturer
        }

}