package br.com.rm553529.cp_04_room.features.city.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "citys")
data class City(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val desc: String,
    val isDone: Boolean
)