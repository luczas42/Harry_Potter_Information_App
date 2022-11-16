package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hp_app.data.api.Repository
import br.com.hp_app.data.model.*
import kotlinx.coroutines.launch

class ListasViewModel(private val repo: Repository) : ViewModel() {

    //Houses
    private val _listaHouses = MutableLiveData<List<Houses>>()
    val listaHouses: LiveData<List<Houses>> = _listaHouses

    fun pegaListaHouses(){
        viewModelScope.launch {
            _listaHouses.value=repo.pegaHouses()
        }
    }

    //Elixirs
    private val _listaElixirs = MutableLiveData<List<Elixirs>>()
    val listaElixirs: LiveData<List<Elixirs>> = _listaElixirs

    fun pegaListaElixirs(){
        viewModelScope.launch {
            _listaElixirs.value = repo.pegaElixirs()
        }
    }

    //Spells
    private val _listaSpells = MutableLiveData<List<Spells>>()
    val listaSpells: LiveData<List<Spells>> = _listaSpells

    fun pegaListaSpells(){
        viewModelScope.launch {
            _listaSpells.value = repo.pegaSpells()
        }
    }

    //Ingredients
    private val _listaIngredients = MutableLiveData<List<Ingredients>>()
    val listaIngredients: LiveData<List<Ingredients>> = _listaIngredients

    fun pegaListaIngredients(){
        viewModelScope.launch {
            _listaIngredients.value = repo.pegaIngredients()
        }
    }

    //Wizards
    private val _listaWizards = MutableLiveData<List<Wizards>>()
    val listaWizards: LiveData<List<Wizards>> = _listaWizards

    fun pegaListaWizards(){
        viewModelScope.launch {
            _listaWizards.value = repo.pegaWizards()
        }
    }
}