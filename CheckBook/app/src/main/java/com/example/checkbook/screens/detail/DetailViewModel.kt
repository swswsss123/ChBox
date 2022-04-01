package com.example.checkbook.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkbook.REPOSITORY
import com.example.checkbook.db.dao.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {

    fun delite(noteModel: NoteModel, onSuccess:()-> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deletNote(noteModel){
                onSuccess()
            }
        }
}