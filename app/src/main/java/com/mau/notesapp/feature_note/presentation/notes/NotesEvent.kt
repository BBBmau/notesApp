package com.mau.notesapp.feature_note.presentation.notes

import com.mau.notesapp.feature_note.domain.model.Notes
import com.mau.notesapp.feature_note.domain.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Notes): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
