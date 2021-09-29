package com.mau.notesapp.di

import android.app.Application
import androidx.room.Room
import com.mau.notesapp.feature_note.data.data_source.NoteDao
import com.mau.notesapp.feature_note.data.data_source.NoteDataBase
import com.mau.notesapp.feature_note.data.repository.NoteRepositoryImpl
import com.mau.notesapp.feature_note.domain.repository.NoteRepository
import com.mau.notesapp.feature_note.domain.use_case.AddNote
import com.mau.notesapp.feature_note.domain.use_case.DeleteNote
import com.mau.notesapp.feature_note.domain.use_case.GetNotes
import com.mau.notesapp.feature_note.domain.use_case.NoteUsecases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoeDatabase(app: Application): NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUsecases{
        return NoteUsecases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}