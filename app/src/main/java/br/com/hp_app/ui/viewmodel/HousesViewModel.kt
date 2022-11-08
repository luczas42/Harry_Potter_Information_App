package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hp_app.api.ApiService
import br.com.hp_app.api.RetrofitInicializador
import br.com.hp_app.model.Houses
import kotlinx.coroutines.launch

class HousesViewModel : ViewModel() {
    private var api : ApiService = RetrofitInicializador.apiService
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _lista = MutableLiveData<List<Houses>>()
    val lista: LiveData<List<Houses>> = _lista

    fun pegaLista(){
        viewModelScope.launch {
            _lista.value=api.pegaHouses()
        }
    }
}