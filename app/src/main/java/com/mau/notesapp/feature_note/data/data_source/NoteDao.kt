package com.mau.notesapp.feature_note.data.data_source

import android.provider.ContactsContract
import androidx.room.*
import com.mau.notesapp.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getNotes(): Flow<List<Notes>> // Returns all Notes from Database

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): Notes?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}