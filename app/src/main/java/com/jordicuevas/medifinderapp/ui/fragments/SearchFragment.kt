package com.jordicuevas.medifinderapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordicuevas.medifinderapp.R
import com.jordicuevas.medifinderapp.application.MediFinderRFApp
import com.jordicuevas.medifinderapp.data.MediFinderRepository
import com.jordicuevas.medifinderapp.data.remote.model.MedicineManager
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import com.jordicuevas.medifinderapp.databinding.FragmentSearchBinding
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

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)



        binding.svMed.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.svMed.clearFocus()
                print(query)
//                lifecycleScope.launch {
//                    val call: Call<DrugLabel> = repository.getDrugNameLabel(null,query, )
//
//                    call.enqueue(object : Callback<List<PerroDto>> {
//                        override fun onResponse(
//                            p0: Call<List<PerroDto>>,
//                            response: Response<List<PerroDto>>
//                        ) {
//
//                            binding.pbLoading.visibility = View.GONE
//                            binding.eaText.visibility = View.INVISIBLE
//
//                            Log.d(Constants.LOGTAG, getString(R.string.respuesta_recibida, response.body()))
//
//                            response.body()?.let { perros ->
//                                binding.rvPerros.apply {
//                                    layoutManager = LinearLayoutManager(requireContext())
//                                    adapter = PerroAdapter(perros) { perro ->
//                                        mediaPlayer.start()
//                                        requireActivity().supportFragmentManager.beginTransaction()
//                                            .replace(
//                                                R.id.fragment_container,
//                                                PerroDetailFragment.newInstance(perro.idPerro.toString())
//                                            )
//                                            .addToBackStack(null)
//                                            .commit()
//                                    }
//                                }
//
//                            }
//
//                        }
//
//                        override fun onFailure(p0: Call<List<PerroDto>>, error: Throwable) {
//                            //Manejo del error
//                            binding.pbLoading.visibility = View.GONE
//                            binding.eaText.visibility = View.VISIBLE
//
////                    Toast.makeText(
////                        requireContext(),
////                        getString(R.string.error_conexion_string, error.message),
////                        Toast.LENGTH_SHORT
////                    ).show()
//                        }
//
//                    })
//                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        repository = (requireActivity().application as MediFinderRFApp).repository


    }

}