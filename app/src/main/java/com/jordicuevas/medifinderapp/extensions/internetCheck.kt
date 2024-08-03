package com.jordicuevas.medifinderapp.extensions

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