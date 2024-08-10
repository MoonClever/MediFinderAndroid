package com.jordicuevas.medifinderapp.extensions

import android.app.AlertDialog
import android.content.Context
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

fun generateCountCriteria(crit1: String?, crit2: String?, reaction: String?): String{
    return "patient.drug.medicinalproduct:%22$crit1%22+AND+" +
            "patient.drug.medicinalproduct:%22$crit2%22+AND+" +
            "patient.reaction.reactionmeddrapt:%22$reaction%22&" +
            "count=patient.reaction.reactionmeddrapt.exact"
}

fun alertPopup(context: Context, title: String, message: String): AlertDialog {
    val alert: AlertDialog.Builder = AlertDialog.Builder(context)
    alert
        .setTitle(title)
        .setMessage(message)
        .setNeutralButton("Ok"){ dialog, which ->
            dialog.dismiss()
        }

    val dialog: AlertDialog = alert.create()
    return dialog
}