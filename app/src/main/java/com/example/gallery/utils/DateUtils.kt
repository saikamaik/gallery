package com.example.gallery.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Locale

class DateUtils {

    private fun convertDateFormat(date: String, sdf: SimpleDateFormat): String {
        val output = SimpleDateFormat("dd.mm.yyyy", Locale.getDefault())
        val d = sdf.parse(date)
        return output.format(d)
    }

    @SuppressLint("SimpleDateFormat")
    fun convertFromStringToDate(date: String): String? {
        val parser = SimpleDateFormat("dd.mm.yyyy")
        val formatter = SimpleDateFormat("yyyy-mm-dd'T'HH:MM:ss")
        return parser.parse(date)?.let { formatter.format(it) }
    }

}