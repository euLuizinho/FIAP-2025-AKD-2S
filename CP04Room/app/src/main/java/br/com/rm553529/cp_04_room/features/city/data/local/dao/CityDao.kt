package br.com.rm553529.cp_04_room.features.city.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.rm553529.cp_04_room.features.city.data.local.entity.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert
    suspend fun insert (city: City)
    @Delete
    suspend fun delete(city: City)
    @Query("SELECT * FROM Citys ORDER BY isDone ASC,id DESC")
    fun getAll(): Flow<List<City>>
    @Query("DELETE FROM Citys")
    suspend fun clearAll()
    @Query("UPDATE citys SET isDone = :isDone WHERE id = :cityId")
    suspend fun updateTaskStatus(cityId: Int, isDone: Boolean)
}