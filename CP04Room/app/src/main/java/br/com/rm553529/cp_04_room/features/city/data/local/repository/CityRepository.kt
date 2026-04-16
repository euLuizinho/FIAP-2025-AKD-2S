package br.com.rm553529.cp_04_room.features.city.data.local.repository

import br.com.rm553529.cp_04_room.features.city.data.local.dao.CityDao
import br.com.rm553529.cp_04_room.features.city.data.local.entity.City

class CityRepository(
    private val dao: CityDao
) {
    val citys = dao.getAll()
    suspend fun insert(city: City) {
        dao.insert(city)
    }
    suspend fun delete(city: City) {
        dao.delete(city)
    }
    suspend fun clearAll(){
        dao.clearAll()
    }
    suspend fun updateCityStatus(cityId: Int, isDone: Boolean) {
        dao.updateTaskStatus(cityId, isDone)
    }
}