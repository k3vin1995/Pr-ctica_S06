package com.inicio.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="estado")

data class Estado(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombreEstado")
    val nombreEstado:String,
    @ColumnInfo(name="pais")
    val pais:String,
    @ColumnInfo(name="capital")
    val capital:String,
    @ColumnInfo(name="poblacion")
    val poblacion:Double,
    @ColumnInfo(name="coordenadas")
    val coordenadas:Double?
) : Parcelable
