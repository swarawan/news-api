package com.swarawan.newsapi.common

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by Rio Swarawn on 7/27/18.
 * 2018-07-27T03:39:00Z
 */
@SuppressLint("SimpleDateFormat")
fun String.toDate(from: String = "yyyy-MM-dd'T'HH:mm:ss'Z'", to: String = "dd MMMM yyyy"): String {
    val dateFormatFrom = SimpleDateFormat(from)
    val date = dateFormatFrom.parse(this)

    val dateFormatTo = SimpleDateFormat(to)
    return dateFormatTo.format(date)
}