package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hp_app.api.ApiService
import br.com.hp_app.api.RetrofitInicializador
import br.com.hp_app.model.Elixirs
import br.com.hp_app.model.Houses
import kotlinx.coroutines.launch

class ListasViewModel : ViewModel() {
    private var api : ApiService = RetrofitInicializador.apiService


    //Houses
    private val _listaHouses = MutableLiveData<List<Houses>>()
    val listaHouses: LiveData<List<Houses>> = _listaHouses

    fun pegaListaHouses(){
        viewModelScope.launch {
            _listaHouses.value=api.pegaHouses()
        }
    }

    //Elixirs
    private val _listaElixirs = MutableLiveData<List<Elixirs>>()

    //Spells
}