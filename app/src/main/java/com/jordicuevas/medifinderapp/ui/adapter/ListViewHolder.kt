package com.jordicuevas.medifinderapp.ui.adapter

import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import com.jordicuevas.medifinderapp.R
import com.jordicuevas.medifinderapp.data.remote.model.Medicine
import com.jordicuevas.medifinderapp.databinding.MedicineElementBinding

class ListViewHolder (private var binding: MedicineElementBinding):
    RecyclerView.ViewHolder(binding.root){

        fun bind(listElem: Medicine){
            val quantityString = "Quantity: ${listElem.quantity}"
            val timeString =  "Time interval: ${listElem.timePerDose} hrs"
            binding.tvGenName.text = listElem.genName
            binding.tvBrandName.text = listElem.branName
            binding.tvTimePerDose.text = quantityString
            binding.tvQuantity.text =  timeString

        }


}