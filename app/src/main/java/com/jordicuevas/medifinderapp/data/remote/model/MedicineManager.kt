package com.jordicuevas.medifinderapp.data.remote.model

import com.jordicuevas.medifinderapp.data.remote.model.adverse.AdverseCount
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import com.jordicuevas.medifinderapp.data.remote.model.drug.Results

class MedicineManager {

    private var listSearchMedicine : MutableList<MedicineSearch> = emptyList<MedicineSearch>().toMutableList()

    fun convertSearchQueryToMedicineSearch(searchQuery : DrugLabel): List<MedicineSearch> {
        searchQuery.results.forEach{result ->
            listSearchMedicine.add(
                MedicineSearch(
                    result.openfda?.genericName?.get(0),
                    result.openfda?.brandName?.get(0),
                    result.openfda?.manufacturerName?.get(0),
                    result.openfda?.route?.get(0)
            )
            )
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
            resultAdd.openfda?.genericName?.get(0),
            resultAdd.openfda?.brandName?.get(0),
            resultAdd.openfda?.route?.get(0),
            resultAdd.activeIngredient.get(0),
            resultAdd.purpose.get(0),
            null,
            resultAdd.indicationsAndUsage.get(0),
            resultAdd.doNotUse.get(0)
        )
    }

    fun convertCuntQueryToInt(resultCount: AdverseCount): Int?{
        return resultCount.results[0].count
    }






}