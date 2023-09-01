package com.curso.android.app.practica.counter.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.counter.model.TextResult
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val textResult: LiveData<TextResult> get() = _textResult

    private var _textResult = MutableLiveData<TextResult>(TextResult("Ingrese 2 cadenas de texto"))

    fun compare(firstString: String, secondString: String) {

        val result: String
        if (firstString == secondString) {
            result = "Son iguales"
        }else {
            result = "Son distintos"
        }
        viewModelScope.launch {
            _textResult.value = TextResult(result)
        }
    }
}
