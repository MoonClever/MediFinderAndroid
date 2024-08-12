package com.jordicuevas.medifinderapp.data.remote.model

import com.jordicuevas.medifinderapp.data.remote.model.adverse.AdverseCount
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import com.jordicuevas.medifinderapp.data.remote.model.drug.Openfda
import com.jordicuevas.medifinderapp.data.remote.model.drug.Results

class MedicineManager {

    private var listSearchMedicine : MutableList<MedicineSearch> = emptyList<MedicineSearch>().toMutableList()

    fun convertSearchQueryToMedicineSearch(searchQuery : DrugLabel): List<MedicineSearch> {
        listSearchMedicine = emptyList<MedicineSearch>().toMutableList()
        var counter = 0
        searchQuery.results.forEach{result ->
            listSearchMedicine.add(
                MedicineSearch(
                    result.openfda?.genericName?.get(0),
                    result.openfda?.brandName?.get(0),
                    result.openfda?.manufacturerName?.get(0),
                    result.openfda?.route?.get(0),
                    counter
            )
            )
            counter++
        }

        return listSearchMedicine
    }

    fun convertQueryToListElement(resultAdd : Results): Medicine {
        return Medicine(
            0,
            0,
            resultAdd.openfda?.genericName?.get(0),
            resultAdd.openfda?.brandName?.get(0),
            null
        )
    }

    fun convertQueryToListDetail(resultAdd : Results): MedicineDetail {
        return MedicineDetail(
            0,
            0,
            resultAdd.openfda,
            null,

        )
    }

    fun convertCountQueryToInt(resultCount: AdverseCount): Int?{
        return resultCount.results[0].count
    }






}