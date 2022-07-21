package com.borisov.pressure.ui.main

/**
 * @author Borisov Andrey on 12.07.2022
 **/
sealed class MainRecyclerRow {

    data class DayRow(val date: String) : MainRecyclerRow()

    data class RecordRow(
        val time: String,
        val systolic: String,
        val diastolic: String,
        val pulse: String,
    ) : MainRecyclerRow()
}