package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hp_app.data.api.Repository
import br.com.hp_app.data.model.*
import kotlinx.coroutines.launch

class ListsViewModel(private val repo: Repository) : ViewModel() {

    //SearchQuery
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    fun getSearchQuery(query: String){
        _searchQuery.value = query
    }

    //Houses
    private val _houseList = MutableLiveData<List<Houses>>()
    val houseList: LiveData<List<Houses>> = _houseList

    fun getHouseList() {
        viewModelScope.launch {
            _houseList.value = repo.getHouses()
        }
    }

    //Elixirs
    private val _elixirList = MutableLiveData<List<Elixirs>>()
    val elixirList: LiveData<List<Elixirs>> = _elixirList

    fun getElixirList() {
        viewModelScope.launch {
            _elixirList.value = repo.getElixirs()
        }
    }

    //Spells
    private val _spellList = MutableLiveData<List<Spells>>()
    val spellList: LiveData<List<Spells>> = _spellList

    fun getSpellList() {
        viewModelScope.launch {
            _spellList.value = repo.getSpells()
        }
    }

    //Ingredients
    private val _ingredientList = MutableLiveData<List<Ingredients>>()
    val ingredientList: LiveData<List<Ingredients>> = _ingredientList

    fun getIngredientList() {
        viewModelScope.launch {
            _ingredientList.value = repo.getIngredients()
        }
    }

    //Wizards
    private val _wizardList = MutableLiveData<List<Wizards>>()
    val wizardList: LiveData<List<Wizards>> = _wizardList

    fun getWizardList() {
        viewModelScope.launch {
            _wizardList.value = repo.getWizards()
        }
    }
}