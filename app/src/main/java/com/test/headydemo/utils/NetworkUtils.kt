package com.test.headydemo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Furqan on 03-01-2019.
 */
class NetworkUtils {
    companion object {
        private fun getActiveNetworkInfo(context: Context): NetworkInfo? {
            return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        }

        fun isConnected(context: Context): Boolean {
            val info = getActiveNetworkInfo(context)
            return info != null && info.isConnected
        }
    }

}