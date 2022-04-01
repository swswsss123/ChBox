package com.example.checkbook.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.checkbook.db.dao.model.NoteModel

//Тут мы даем описание для Room

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)  //если будет конфликт игнорировать его
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)  //удоление

    @Query("SELECT * from note_table")  //запрос к базе что бы лна выбрала все из сомой себя
    fun getAllNotes():LiveData<List<NoteModel>>
}