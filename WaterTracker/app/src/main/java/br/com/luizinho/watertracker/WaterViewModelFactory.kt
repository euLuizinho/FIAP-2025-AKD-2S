package br.com.luizinho.watertracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WaterViewModelFactory(
    private val repository: WaterRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>):
            T {
        if
                (modelClass.isAssignableFrom(WaterViewModel::class.java)) {
            return WaterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}