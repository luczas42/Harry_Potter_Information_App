package br.com.hp_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElixirsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Elixirs"
    }
    val text: LiveData<String> = _text
}