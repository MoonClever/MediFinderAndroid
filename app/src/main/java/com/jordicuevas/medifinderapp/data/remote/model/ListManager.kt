package com.jordicuevas.medifinderapp.data.remote.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

class ListManager(context: Context){
    private lateinit var results : MutableList<Medicine>
    private lateinit var details : MutableList<MedicineDetail>

    val gson = Gson()
    val pathList = "medList.json"
    val pathDetail = "medDetail.json"

    val sessionContext : Context = context

    val fileList = File(sessionContext.filesDir,pathList)
    val fileDetail = File(sessionContext.filesDir,pathDetail)

    init {

        try {
            if (!fileList.exists() || !fileDetail.exists()){
                fileList.createNewFile()
                fileDetail.createNewFile()
            }
            if (fileList.length().toInt() == 0 || fileDetail.length().toInt() == 0){
                results = emptyList<Medicine>().toMutableList()
                details = emptyList<MedicineDetail>().toMutableList()

            }
            else{
                val typeList = object : TypeToken<MutableList<Medicine>>(){}.type
                this.results = gson.fromJson(fileList.readText(), typeList)

                val typeDetail = object : TypeToken<MutableList<MedicineDetail>>(){}.type
                    this.details = gson.fromJson(fileList.readText(), typeDetail)

            }

            Log.d("Manager","Result: ${this.results}")
            Log.d("Manager","Result: ${this.details}")
        }
        catch (e: IOException){
            Log.d("Manager","Error thrown: ${e}")
        }
    }

    fun updateLists(){
        try {
            if (fileList.length().toInt() == 0 || fileDetail.length().toInt() == 0){
                results = emptyList<Medicine>().toMutableList()
                details = emptyList<MedicineDetail>().toMutableList()
            }

            else{
                val typeList = object : TypeToken<MutableList<Medicine>>(){}.type
                this.results = gson.fromJson(fileList.readText(), typeList)

                val typeDetail = object : TypeToken<MutableList<MedicineDetail>>(){}.type
                this.details = gson.fromJson(fileList.readText(), typeDetail)

            }

            Log.d("Manager","Result: ${this.results}")
            Log.d("Manager","Result: ${this.details}")
        }
        catch (e: IOException){
            Log.d("Manager","Error thrown: ${e}")
        }
    }

    //CRUD: Create
    fun createElementList(newMed: Medicine){
        val list = readList()
        list.add(newMed)
        val json = gson.toJson(list)
        fileList.writeText(json)
        return
    }

    fun createElementDetail(newDet: MedicineDetail){
        val list = readDetails()
        list.add(newDet)
        val json = gson.toJson(list)
        fileDetail.writeText(json)
        return
    }

    //CRUD: Read
    fun readList(): MutableList<Medicine> {
        return this.results
    }

    fun listAt(index: Int):Medicine{
        val list = readList()
        val elemList = list.elementAt(index)
        return elemList
    }

    fun listElementCount():Int{
        val list = readList()
        val count = list.count()
        return count
    }

    fun readDetails(): MutableList<MedicineDetail> {
        return this.details
    }

    fun detailAt(index: Int):MedicineDetail{
        val list = readDetails()
        val elemList = list.elementAt(index)
        return elemList
    }

    fun detailElementCount():Int{
        val list = readDetails()
        val count = list.count()
        return count
    }

    //CRUD: Update
    fun updateListElement(updateList: Medicine, pos: Int){
        val list = readList()
        list[pos] = updateList
        val json = gson.toJson(list)
        fileList.writeText(json)
        return
    }

    fun updateDetailsElement(updateDetail: MedicineDetail, pos: Int){
        val list = readDetails()
        list[pos] = updateDetail
        val json = gson.toJson(list)
        fileDetail.writeText(json)
        return
    }

    //CRUD: Delete

    fun deleteListElementAt(index: Int){
        val list = readList()
        list.removeAt(index)
        val json = gson.toJson(list)
        fileList.writeText(json)
    }

    fun deleteDetailElementAt(index: Int){
        val list = readDetails()
        list.removeAt(index)
        val json = gson.toJson(list)
        fileDetail.writeText(json)
    }
}