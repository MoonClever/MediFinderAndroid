package com.jordicuevas.medifinderapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jordicuevas.medifinderapp.data.remote.model.LocalStorage.manager
import com.jordicuevas.medifinderapp.data.remote.model.LocalStorage.pos
import com.jordicuevas.medifinderapp.databinding.FragmentMedListBinding
import com.jordicuevas.medifinderapp.databinding.FragmentMedListDetailBinding


class MedListDetailFragment : Fragment() {

    private var _binding: FragmentMedListDetailBinding? = null
    private val binding get() = _binding!!

    var detailMed = manager.detailAt(pos)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedListDetailBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {
            //updateDetail
            activity?.supportFragmentManager?.popBackStack()

        }

        binding.btnDelete.setOnClickListener {
            //DeleteDetail
            activity?.supportFragmentManager?.popBackStack()

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvBrandName.text = detailMed.medData?.brandName?.get(0) ?: "Not found"
        binding.tvGenericName.text = detailMed.medData?.genericName?.get(0) ?: "Not found"
        binding.tvManufacturer.text = detailMed.medData?.manufacturerName?.get(0) ?: "Not found"
        binding.etTime.setText(detailMed.timePerDose.toString())
        binding.etQuantity.setText(detailMed.quantity.toString())
        binding.tvRoute.text = detailMed.medData?.route?.get(0) ?: "Not found"
        binding.tvPackage.text = detailMed.medData?.packageNdc?.get(0) ?: "Not found"
        binding.tvUNII.text = detailMed.medData?.unii?.get(0) ?: "Not found"
        binding.tvUPC.text = detailMed.medData?.upc?.get(0) ?: "Not found"



    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }


}