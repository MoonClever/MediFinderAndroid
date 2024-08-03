package com.jordicuevas.medifinderapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.jordicuevas.medifinderapp.data.remote.model.Medicine
import com.jordicuevas.medifinderapp.databinding.MedicineElementBinding

class ListViewHolder (private var binding: MedicineElementBinding):
    RecyclerView.ViewHolder(binding.root){

        val tvQuantity = binding.tvQuantity
        val tvTime = binding.tvTimePerDose
        val ivThumbnail = binding.ivThumbnail

        fun bind(listElem: Medicine){
            binding.tvGenName.text = listElem.genName
            binding.tvBrandName.text = listElem.branName

        }


}