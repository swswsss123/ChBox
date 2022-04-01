package com.example.checkbook.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkbook.REPOSITORY
import com.example.checkbook.db.dao.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//функция реализуешая добавление заметки
class AddNoteViewModel: ViewModel() {


    fun insert(noteModel: NoteModel,onSuccess:()-> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
}