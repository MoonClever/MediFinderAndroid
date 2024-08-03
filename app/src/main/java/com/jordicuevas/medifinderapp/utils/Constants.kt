package com.jordicuevas.medifinderapp.utils

object Constants {

    const val BASE_URL: String = "https://api.fda.gov/drug/"

    const val DRUG_URL: String = "event.json?"

    const val EVENT_URL: String = "label.json?"

    const val SEARCH_QUERY_PARAM = "search="

    const val COUNT_QUERY_PARAM = "count="

    const val GENERIC_NAME_QUERY_TERM = "patient.drug.openfda.generic_name:"

    const val BRAND_NAME_QUERY_TERM = "patient.drug.openfda.brand_name:"

    const val PATIENT_REACTION_QUERY_TERM = "patient.reaction.reactionmeddrapt.exact"

    const val LIMIT_QUERY_PARAM = "&limit="

    const val LOGTAG = "LOGS"

}