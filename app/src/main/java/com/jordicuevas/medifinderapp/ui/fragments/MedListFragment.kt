package com.jordicuevas.medifinderapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.jordicuevas.medifinderapp.R
import com.jordicuevas.medifinderapp.data.remote.model.ListManager
import com.jordicuevas.medifinderapp.databinding.FragmentMedListBinding


class MedListFragment : Fragment() {

    private var _binding: FragmentMedListBinding? = null
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedListBinding.inflate(inflater, container, false)

        var listManager = ListManager(requireContext())

        binding.rvListMed.apply{
            layoutManager = LinearLayoutManager(requireContext())
            adapter = com.jordicuevas.medifinderapp.ui.adapter.ListAdapter(
                listManager.readList(),
                listManager.readDetails()
            ) { details ->

                //Mostrar detalles de vista

//                requireActivity().supportFragmentManager.beginTransaction()
//                    .replace(
//                        R.id.fragment_container,
//                        MedListDetailFragment.newInstance(perro.idPerro.toString())
//                    )
//                    .addToBackStack(null)
//                    .commit()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        }



    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

}