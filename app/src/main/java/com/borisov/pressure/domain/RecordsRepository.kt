package com.borisov.pressure.domain

import com.borisov.pressure.data.Record
import kotlinx.coroutines.flow.Flow

/**
 * @author Borisov Andrey on 12.07.2022
 **/
interface RecordsRepository {
    fun records(): Flow<Set<Record>>
    fun saveRecord(record: Record)
}