package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hp_app.data.api.Repository
import br.com.hp_app.data.model.*
import kotlinx.coroutines.launch

class DetailsViewModel(private val repo: Repository) : ViewModel() {

    //Houses
    private val _selectedHouse = MutableLiveData<Houses>()
    val selectedHouse: LiveData<Houses> = _selectedHouse

    fun getSelectedHouse(idHouse: String) {
        viewModelScope.launch {
            val houses: Houses = repo.getHousesById(idHouse)
            _selectedHouse.value = houses
        }
    }

    //Elixirs
    private val _selectedElixir = MutableLiveData<Elixirs>()
    val selectedElixir: LiveData<Elixirs> = _selectedElixir

    fun getSelectedElixir(idElixir: String) {
        viewModelScope.launch {
            val elixir: Elixirs = repo.getElixirsById(idElixir)
            _selectedElixir.value = elixir
        }
    }

    //Spells
    private val _selectedSpell = MutableLiveData<Spells>()
    val selectedSpell: LiveData<Spells> = _selectedSpell

    fun getSelectedSpell(idSpell: String) {
        viewModelScope.launch {
            val spell: Spells = repo.getSpellsById(idSpell)
            _selectedSpell.value = spell
        }
    }

    //Wizards

    private val _selectedWizard = MutableLiveData<Wizards>()
    val selectedWizard: LiveData<Wizards> = _selectedWizard

    fun getSelectedWizard(wizardId: String) {
        viewModelScope.launch {
            val wizard: Wizards = repo.getWizardById(wizardId)
            _selectedWizard.value = wizard
        }
    }

    //Ingredients
    private val _selectedIngredient = MutableLiveData<Ingredients>()
    val selectedIngredient: LiveData<Ingredients> = _selectedIngredient

    fun getSelectedIngredient(ingredientId: String) {
        viewModelScope.launch {
            val ingredient: Ingredients = repo.getIngredientById(ingredientId)
            _selectedIngredient.value = ingredient
        }
    }
}