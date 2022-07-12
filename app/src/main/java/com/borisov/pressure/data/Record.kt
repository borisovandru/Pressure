package com.borisov.pressure.data

/**
 * @author Borisov Andrey on 12.07.2022
 **/
data class Record(
    val time: Long,
    val systolic: Int,
    val diastolic: Int,
    val pulse: Int,
)