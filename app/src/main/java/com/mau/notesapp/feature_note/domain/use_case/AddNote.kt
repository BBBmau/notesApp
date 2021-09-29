package com.mau.notesapp.feature_note.domain.use_case

import com.mau.notesapp.feature_note.domain.model.InvalidNoteException
import com.mau.notesapp.feature_note.domain.model.Notes
import com.mau.notesapp.feature_note.domain.repository.NoteRepository

class AddNote (
    private val repository: NoteRepository
){
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Notes){
        if(note.title.isBlank()){
            throw InvalidNoteException("The Title of the Note Can't be Empty.")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note Can't be Empty.")
        }
        repository.insertNote(note)
    }
}