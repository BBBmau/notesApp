package com.mau.notesapp.feature_note.domain.use_case

import com.mau.notesapp.feature_note.domain.model.Notes
import com.mau.notesapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Notes){
        repository.deleteNote(note)
    }
}