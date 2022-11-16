package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hp_app.data.api.Repository
import br.com.hp_app.data.model.Elixirs
import br.com.hp_app.data.model.Houses
import kotlinx.coroutines.launch

class DetalhesViewModel(private val repo: Repository) : ViewModel() {

    //Houses
    private val _selectedHouse = MutableLiveData<Houses>()
    val selectedHouse: LiveData<Houses> = _selectedHouse

    fun pegaHouseSelecionada(idHouse: String) {
        viewModelScope.launch {
            val houses: Houses = repo.pegaHousesPorId(idHouse)
            _selectedHouse.value = houses
        }
    }

    //Elixirs
    private val _selectedElixir = MutableLiveData<Elixirs>()
    val selectedElixir: LiveData<Elixirs> = _selectedElixir

    fun pegaElixirSelecionado(idElixir: String) {
        viewModelScope.launch {
            val elixir: Elixirs = repo.pegaElixirsPorId(idElixir)
            _selectedElixir.value = elixir
        }
    }
}