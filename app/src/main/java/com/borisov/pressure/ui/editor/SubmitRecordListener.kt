package com.borisov.pressure.ui.editor

import com.borisov.pressure.data.Record

/**
 * @author Borisov Andrey on 12.07.2022
 **/

interface SubmitRecordListener {
    fun submitRecord(record: Record)
}