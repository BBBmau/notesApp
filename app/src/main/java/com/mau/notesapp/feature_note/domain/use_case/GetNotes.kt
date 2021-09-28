package com.mau.notesapp.feature_note.domain.use_case

import com.mau.notesapp.feature_note.domain.model.Notes
import com.mau.notesapp.feature_note.domain.repository.NoteRepository
import com.mau.notesapp.feature_note.domain.util.NoteOrder
import com.mau.notesapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Notes>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                        }
                    }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
            }
        }
    }
}