package com.mau.notesapp.feature_note.data.repository

import android.provider.ContactsContract
import com.mau.notesapp.feature_note.data.data_source.NoteDao
import com.mau.notesapp.feature_note.domain.model.Notes
import com.mau.notesapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
    ): NoteRepository {

    override fun getNotes(): Flow<List<Notes>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Notes? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Notes) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Notes) {
        return deleteNote(note)
    }
}