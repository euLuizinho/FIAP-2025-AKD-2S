package br.com.rm553529.cp_04_room.features.city.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm553529.cp_04_room.features.city.data.local.entity.City
import br.com.rm553529.cp_04_room.features.city.data.local.repository.CityRepository
import kotlinx.coroutines.launch

class CityViewModel(
    private val repository: CityRepository
) : ViewModel(){
    val citys = repository.citys
    fun addCity(title: String, desc: String) {
        viewModelScope.launch {
            repository.insert(City(
                title = title,
                desc = desc,
                isDone = false
            ))
        }
    }
    fun removeCity(city: Int){
        viewModelScope.launch {
            repository.delete(city)
        }
    }
    fun clearAllCitys(){
        viewModelScope.launch{
            repository.clearAll()
        }
    }
    fun onCityChecked (city: City, checked: Boolean) {
        viewModelScope.launch {
            repository.updateCityStatus(
                cityId = city.id,
                isDone = checked
            )
        }
    }
}