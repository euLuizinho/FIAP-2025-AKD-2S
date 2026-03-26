package br.com.luizinho.watertracker

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InMemoryWaterRepository : WaterRepository{

    private val cupsDrunkFlow = MutableStateFlow(0)

    override fun getCupsDrunk(): Flow<Int> {
        return cupsDrunkFlow.asStateFlow()
    }

    override fun saveCupsDrunk(value: Int) {
        cupsDrunkFlow.value = value
    }

    override suspend fun clear() {
        cupsDrunkFlow.value = 0
    }


}