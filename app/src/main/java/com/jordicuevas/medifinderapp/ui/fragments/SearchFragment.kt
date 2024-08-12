package com.jordicuevas.medifinderapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordicuevas.medifinderapp.R
import com.jordicuevas.medifinderapp.application.MediFinderRFApp
import com.jordicuevas.medifinderapp.data.MediFinderRepository
import com.jordicuevas.medifinderapp.data.remote.model.ListManager
import com.jordicuevas.medifinderapp.data.remote.model.LocalStorage.manager
import com.jordicuevas.medifinderapp.data.remote.model.Medicine
import com.jordicuevas.medifinderapp.data.remote.model.MedicineDetail
import com.jordicuevas.medifinderapp.data.remote.model.MedicineManager
import com.jordicuevas.medifinderapp.data.remote.model.MedicineSearch
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import com.jordicuevas.medifinderapp.databinding.FragmentSearchBinding
import com.jordicuevas.medifinderapp.extensions.checkNameCriteria
import com.jordicuevas.medifinderapp.extensions.generateNameCriteria
import com.jordicuevas.medifinderapp.extensions.isInternetAvailable
import com.jordicuevas.medifinderapp.extensions.snackPop
import com.jordicuevas.medifinderapp.ui.adapter.SearchAdapter
import com.jordicuevas.medifinderapp.utils.Constants
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: MediFinderRepository
    private val medManager = MedicineManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.query_limit,
            android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter
        }

        return binding.root

    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        repository = (requireActivity().application as MediFinderRFApp).repository

        binding.svMed.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.svMed.clearFocus()
                //binding.tvNoInternetConnection.text = checkNameCriteria(binding.rgMed.checkedRadioButtonId) + query + binding.spinner.selectedItem.toString()

                if (isInternetAvailable(requireContext())){
                    lifecycleScope.launch {
                        val call: Call<DrugLabel> = repository.getDrugNameLabel(
                            generateNameCriteria(checkNameCriteria(binding.rB1Med.isChecked), query) ,
                            binding.spinner.selectedItem.toString())

                        call.enqueue(object : Callback<DrugLabel> {
                            override fun onResponse(
                                p0: Call<DrugLabel>,
                                response: Response<DrugLabel>
                            ) {

                                binding.tvNoInternetConnection.visibility = View.INVISIBLE

                                if(response.code() == 404){
                                    snackPop(view, "No se encontraron resultados").show()
                                }

                                response.body()?.let { drugs ->
                                    print(drugs.results)
                                    binding.rvSearchMed.apply {
                                        layoutManager = LinearLayoutManager(requireContext())
                                        adapter = SearchAdapter(
                                            medManager.convertSearchQueryToMedicineSearch(drugs)
                                        ) { drug ->
                                            manager.createElementList(
                                                medManager.convertQueryToListElement(
                                                    drugs.results.get(drug.id)
                                                )
                                            )
                                            manager.createElementDetail(
                                                medManager.convertQueryToListDetail(
                                                    drugs.results.get(drug.id)
                                                )
                                            )
                                            snackPop(
                                                view,
                                                "Elemento agregado exitosamente"
                                            ).show()
                                        }
                                    }
                                }
                            }

                            override fun onFailure(p0: Call<DrugLabel>, error: Throwable) {
                                //Manejo del error
                                binding.tvNoInternetConnection.visibility = View.VISIBLE

                                snackPop(view, "Error al hacer query").show()
                            }

                        })
                    }
                }
                else{
                    snackPop(view, "No hay conexión a internet, intente de nuevo").show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

}