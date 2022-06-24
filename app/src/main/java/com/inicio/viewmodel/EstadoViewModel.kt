package com.inicio.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.inicio.data.EstadoDatabase
import com.inicio.model.Estado
import com.inicio.repository.EstadoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EstadoViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Estado>>

    private val repository: EstadoRepository

    init {
        val estadoDao = EstadoDatabase.getDatabase(application).estadoDao()
        repository = EstadoRepository(estadoDao)
        getAllData = repository.getAllData
    }

    fun addEstado (estado: Estado) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEstado(estado)
        }
    }

    fun updateEstado (estado: Estado) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateEstado(estado)
        }
    }

    fun deleteEstado (estado: Estado) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteEstado(estado)
        }
    }
}