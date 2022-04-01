package com.example.checkbook.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.checkbook.REPOSITORY
import com.example.checkbook.db.dao.NoteDatabase
import com.example.checkbook.db.dao.model.NoteModel
import com.example.checkbook.db.dao.repository.NoteRealezation

class StartViewModel(application: Application):AndroidViewModel(application) {

    val context =application

    fun initDatabase() {
        //иницилизируем нашу базу данных из абстрактного метода
        val daoNote = NoteDatabase.getInstance(context).getNoteDaoo()
        REPOSITORY =NoteRealezation(daoNote)
    }
    fun  getAllNotes():LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}