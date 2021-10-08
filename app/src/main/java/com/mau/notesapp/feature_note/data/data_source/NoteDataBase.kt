package com.mau.notesapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mau.notesapp.feature_note.domain.model.Notes

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object{
        const val DATABASE_NAME = "notes_DB"
    }
}