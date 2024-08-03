package com.jordicuevas.medifinderapp.extensions

import com.jordicuevas.medifinderapp.utils.Constants
import java.net.InetAddress
import java.net.UnknownHostException


fun isInternetAvailable(): Boolean {
    try {
        val address = InetAddress.getByName("www.google.com")
        return true
    } catch (e: UnknownHostException) {
        // Log error
        print("Error de conexion")
    }
    return false
}

fun checkNameCriteria(int: Int): String{
    if (int == 1){
        return Constants.BRAND_NAME_QUERY_TERM
    }
    else{
        return Constants.GENERIC_NAME_QUERY_TERM
    }
}

fun generateNameCriteria(crit: String?, search: String?): String{
    return "openfda.$crit.$search"
}