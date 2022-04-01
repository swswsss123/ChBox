package com.example.checkbook.db.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.checkbook.db.dao.model.NoteModel

// этот Абстрактный Класс ИНАЦАЛИЗИРУЕТ НАШУ БАЗУ ДАННЫХ

@Database(entities = [NoteModel::class], version = 1
)
abstract class NoteDatabase:RoomDatabase() {

    abstract fun getNoteDaoo():NoteDao

    companion object{

        private var database: NoteDatabase ?= null

        @Synchronized
        fun getInstance(context: Context):NoteDatabase{

            return  if(database == null){
                database = Room.databaseBuilder(context,NoteDatabase::class.java,"db").build()
                database as NoteDatabase  //если базы нет то создать ее
            }else{
                database as  NoteDatabase  // если база есть то просто открытьл ее
            }
        }
    }
}