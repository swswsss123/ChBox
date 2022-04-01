package com.example.checkbook.db.dao.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor
import java.io.Serializable


@Entity(tableName = "note_table")   //создаем табличку в Room
class NoteModel (
    @PrimaryKey(autoGenerate = true) //автогенерация id
    var id:Int = 0,

    @ColumnInfo  //иницилизируем колонки что бы название было такое же
    var tile:String = "",
    @ColumnInfo
    var descriptor:String = ""
        ) : Serializable