package com.jordicuevas.medifinderapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordicuevas.medifinderapp.R
import com.jordicuevas.medifinderapp.application.MediFinderRFApp
import com.jordicuevas.medifinderapp.data.MediFinderRepository
import com.jordicuevas.medifinderapp.data.remote.model.ListManager
import com.jordicuevas.medifinderapp.data.remote.model.MedicineManager
import com.jordicuevas.medifinderapp.data.remote.model.adverse.AdverseCount
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import com.jordicuevas.medifinderapp.databinding.FragmentHomeBinding
import com.jordicuevas.medifinderapp.extensions.checkNameCriteria
import com.jordicuevas.medifinderapp.extensions.generateCountCriteria
import com.jordicuevas.medifinderapp.extensions.generateNameCriteria
import com.jordicuevas.medifinderapp.ui.adapter.SearchAdapter
import com.jordicuevas.medifinderapp.utils.Constants
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: MediFinderRepository
    private val medManager = MedicineManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.reactions_array,
            android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.reactionSpinner.adapter = adapter
        }
        return binding.root


    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = (requireActivity().application as MediFinderRFApp).repository

        binding.sendQueryBtn.setOnClickListener {
            lifecycleScope.launch {
                val call: Call<AdverseCount> = repository.getReactionCountQuery(
                    generateCountCriteria(binding.etMed1.text.toString(),
                    binding.etMed2.text.toString(),
                    binding.reactionSpinner.selectedItem.toString()),
                        "1")

                Log.d(Constants.LOGTAG, generateCountCriteria(binding.etMed1.text.toString(),
                    binding.etMed2.text.toString(),
                    binding.reactionSpinner.selectedItem.toString()))

                call.enqueue(object : Callback<AdverseCount> {
                    override fun onResponse(
                        p0: Call<AdverseCount>,
                        response: Response<AdverseCount>
                    ) {

                        binding.tvNoInternetConnection.visibility = View.INVISIBLE

                        Log.d(Constants.LOGTAG, "Query realizado")


                        response.body()?.let { count ->
                                //Log.d(Constants.LOGTAG, medManager.convertCountQueryToInt(count).toString())
                                val countQuery = medManager.convertCountQueryToInt(count)
                                binding.tvResults.text = "Coincidencias encontradas: .$countQuery"
                            }
                        }


                    override fun onFailure(p0: Call<AdverseCount>, error: Throwable) {
                        //Manejo del error
                        binding.tvNoInternetConnection.visibility = View.VISIBLE

                        Toast.makeText(
                            requireContext(),
                            "Error al hacer query",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                })
            }
        }


    }

}