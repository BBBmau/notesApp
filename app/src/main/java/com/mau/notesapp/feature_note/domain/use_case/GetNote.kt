package com.mau.notesapp.feature_note.domain.use_case

import android.provider.ContactsContract
import com.mau.notesapp.feature_note.domain.model.Notes
import com.mau.notesapp.feature_note.domain.repository.NoteRepository

class GetNote(private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Notes? {
        return repository.getNoteById(id)
    }
}