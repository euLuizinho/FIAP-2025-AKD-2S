package br.com.luizinho.watertracker

import kotlinx.coroutines.flow.Flow


interface WaterRepository {

    fun getCupsDrunk(): Flow<Int>

    fun saveCupsDrunk(value: Int)

    suspend fun clear()
}
