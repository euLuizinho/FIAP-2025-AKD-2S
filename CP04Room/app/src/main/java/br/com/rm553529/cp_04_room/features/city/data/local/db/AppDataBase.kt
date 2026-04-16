package br.com.rm553529.cp_04_room.features.city.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.rm553529.cp_04_room.features.city.data.local.dao.CityDao
import br.com.rm553529.cp_04_room.features.city.data.local.entity.City

@Database(entities = [City::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}