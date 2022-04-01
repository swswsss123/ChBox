package com.example.checkbook.db.dao.repository

import androidx.lifecycle.LiveData
import com.example.checkbook.db.dao.NoteDao
import com.example.checkbook.db.dao.model.NoteModel


// В этом класе мы обьединяем  Интерфейсы NoteDao и NoteDaoRepository  и РЕАЛИЗУЕМ ИХ РАБОТУ

class NoteRealezation(private val noteDao: NoteDao): NoteDaoRepository {

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deletNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}