package com.jordicuevas.medifinderapp.data.remote.model.drug

import com.google.gson.annotations.SerializedName

//OpenFDA object as described in openFDA API
data class Openfda (
  @SerializedName("application_number"   ) var applicationNumber  : ArrayList<String>  = arrayListOf(),
  @SerializedName("brand_name"           ) var brandName          : ArrayList<String>  = arrayListOf(),
  @SerializedName("generic_name"         ) var genericName        : ArrayList<String>  = arrayListOf(),
  @SerializedName("is_original_packager" ) var isOriginalPackager : ArrayList<Boolean> = arrayListOf(),
  @SerializedName("manufacturer_name"    ) var manufacturerName   : ArrayList<String>  = arrayListOf(),
  @SerializedName("nui"                  ) var nui                : ArrayList<String>  = arrayListOf(),
  @SerializedName("original_packager_product_ndc")
                                     var originalPackagerProductNdc: ArrayList<String> = arrayListOf(),
  @SerializedName("package_ndc"          ) var packageNdc         : ArrayList<String>  = arrayListOf(),
  @SerializedName("pharm_class_cs"       ) var pharmClassCs       : ArrayList<String>  = arrayListOf(),
  @SerializedName("pharm_class_epc"      ) var pharmClassEpc      : ArrayList<String>  = arrayListOf(),
  @SerializedName("pharm_class_pe"       ) var pharmClassPe       : ArrayList<String>  = arrayListOf(),
  @SerializedName("pharm_class_moa"      ) var pharmClassMoa      : ArrayList<String>  = arrayListOf(),
  @SerializedName("product_ndc"          ) var productNdc         : ArrayList<String>  = arrayListOf(),
  @SerializedName("product_type"         ) var productType        : ArrayList<String>  = arrayListOf(),
  @SerializedName("route"                ) var route              : ArrayList<String>  = arrayListOf(),
  @SerializedName("rxcui"                ) var rxcui              : ArrayList<String>  = arrayListOf(),
  @SerializedName("spl_id"               ) var splId              : ArrayList<String>  = arrayListOf(),
  @SerializedName("spl_set_id"           ) var splSetId           : ArrayList<String>  = arrayListOf(),
  @SerializedName("substance_name"       ) var substanceName      : ArrayList<String>  = arrayListOf(),
  @SerializedName("unii"                 ) var unii               : ArrayList<String>  = arrayListOf(),
  @SerializedName("upc"                  ) var upc                : ArrayList<String>  = arrayListOf()

)