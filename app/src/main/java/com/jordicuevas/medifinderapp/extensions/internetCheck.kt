package com.jordicuevas.medifinderapp.extensions

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.jordicuevas.medifinderapp.utils.Constants
import java.net.InetAddress
import java.net.UnknownHostException


fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager != null) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
    }
    return false
}

fun checkNameCriteria(check: Boolean): String{
    if (!check){
        return Constants.BRAND_NAME_QUERY_TERM
    }
    else{
        return Constants.GENERIC_NAME_QUERY_TERM
    }
}

fun generateNameCriteria(crit: String?, search: String?): String{
    return "openfda.$crit$search"
}

fun generateCountCriteria(crit1: String?, crit2: String?, reaction: String?): String{
    return "patient.drug.medicinalproduct:$crit1+AND+patient.drug.medicinalproduct:$crit2+AND+patient.reaction.reactionmeddrapt:$reaction"
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

fun snackPop(view: View, message: String): Snackbar {
    val snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
    return snack
}
