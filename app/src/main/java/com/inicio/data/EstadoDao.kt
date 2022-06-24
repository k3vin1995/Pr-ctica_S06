package com.inicio.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.inicio.model.Estado

@Dao
interface EstadoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEstado(estado: Estado)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateEstado(estado: Estado)

    @Delete
    suspend fun deleteEstado(estado: Estado)

    @Query ("SELECT * FROM ESTADO")
    fun getAllData(): LiveData<List<Estado>>
}