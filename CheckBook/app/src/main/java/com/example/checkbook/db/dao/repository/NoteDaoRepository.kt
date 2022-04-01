package com.example.checkbook.db.dao.repository

import androidx.lifecycle.LiveData
import com.example.checkbook.db.dao.model.NoteModel

interface NoteDaoRepository {
    // описаваеться методы которые используються ДЛЯ СЕБЯ
    val allNotes:LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel,onSuccess:() -> Unit)  //запись
    suspend fun deletNote(noteModel: NoteModel,onSuccess:() -> Unit)   //удоление
}