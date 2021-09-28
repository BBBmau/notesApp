package com.mau.notesapp.feature_note.domain.repository

import android.provider.ContactsContract
import com.mau.notesapp.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Notes>>

    suspend fun getNoteById(id: Int): Notes?

    suspend fun insertNote(note: Notes)
    suspend fun deleteNote(note: Notes)
}