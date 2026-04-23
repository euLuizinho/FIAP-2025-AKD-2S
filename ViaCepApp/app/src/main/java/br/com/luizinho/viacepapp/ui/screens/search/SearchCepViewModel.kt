package br.com.luizinho.viacepapp.ui.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.luizinho.viacepapp.core.ui.UiState
import br.com.luizinho.viacepapp.model.CepResponse
import br.com.luizinho.viacepapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchCepViewModel : ViewModel() {

    var cep by mutableStateOf("")
        private set
    var uiState by mutableStateOf<UiState<CepResponse>>(UiState.Initial)
        private set

    fun onCepChange(newValue: String) {
        cep = newValue.filter { it.isDigit() }.take(8)

        if (uiState is UiState.Error) {
            uiState = UiState.Initial
        }
    }

    fun searchCep() {
        uiState = UiState.Loading

        val cepClear = cep.filter { it.isDigit() }

        if (cepClear.length != 8) {
            uiState = UiState.Error("CEP inválido")
            return
        }

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.buscarCep(cepClear)
                uiState = UiState.Success(response)
            }catch (e: Exception){
                uiState = UiState.Error("Erro ao buscar CEP")
            }

        }

    }


}
