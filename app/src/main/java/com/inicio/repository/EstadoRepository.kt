package com.inicio.repository

import androidx.lifecycle.LiveData
import com.inicio.data.EstadoDao
import com.inicio.model.Estado

class EstadoRepository(private val estadoDao: EstadoDao) {

    val getAllData: LiveData<List<Estado>> = estadoDao.getAllData()

    suspend fun addEstado(estado: Estado) {
        estadoDao.addEstado(estado)
    }

    suspend fun updateEstado(estado: Estado) {
        estadoDao.updateEstado(estado)
    }

    suspend fun deleteEstado(estado: Estado) {
        estadoDao.deleteEstado(estado)
    }
}