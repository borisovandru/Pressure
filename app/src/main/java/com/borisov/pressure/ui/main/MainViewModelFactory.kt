package com.borisov.pressure.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.borisov.pressure.domain.RecordsRepository

/**
 * @author Borisov Andrey on 12.07.2022
 **/
class MainViewModelFactory(
    private val recordsRepository: RecordsRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when (modelClass) {
            MainViewModel::class.java -> MainViewModel(recordsRepository)
            else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
        } as T
}