package com.mau.notesapp.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity
data class Notes(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id : Int? = null
){
    companion object{
        val noteColors = listOf(Color.Green, Color.Magenta, Color.Red, Color.Yellow)
    }
}

class InvalidNoteException(message: String): Exception(message)