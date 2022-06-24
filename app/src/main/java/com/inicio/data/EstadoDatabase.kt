package com.inicio.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.inicio.model.Estado

@Database(entities = [Estado::class], version = 1, exportSchema = false)

abstract class EstadoDatabase : RoomDatabase() {
    abstract fun estadoDao() : EstadoDao

    companion object {
        @Volatile
        private var INSTANCE: EstadoDatabase? = null

        fun getDatabase(context: android.content.Context) : EstadoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EstadoDatabase::class.java,
                    "practica"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}