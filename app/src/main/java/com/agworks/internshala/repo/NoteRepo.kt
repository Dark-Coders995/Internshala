package com.agworks.internshala.repo


import android.app.Application
import androidx.lifecycle.LiveData
import com.agworks.internshala.db.NoteDB
import com.agworks.internshala.entity.NoteModel


class NoteRepo(application: Application) {

    var noteDao = NoteDB.getDatabase(application).noteDao()

    fun getAllNotes(mailId: String): LiveData<List<NoteModel>> = noteDao.getAllNotes(mailId)

    suspend fun insert(note: NoteModel) {
        noteDao.insert(note)
    }

    suspend fun update(note: NoteModel) {
        noteDao.update(note)
    }

    suspend fun delete(note: NoteModel) {
        noteDao.delete(note)
    }

}