package com.agworks.internshala.ui

import android.app.Application
import androidx.lifecycle.*
import com.agworks.internshala.db.NoteDB
import com.agworks.internshala.entity.NoteModel
import com.agworks.internshala.repo.NoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var repos: NoteRepo

    init {
        val dao = NoteDB.getDatabase(application).noteDao()
        repos = NoteRepo(application)
    }

    fun insertNode(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        repos.insert(note)
    }

    fun updateNode(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        repos.update(note)
    }

    fun deleteNode(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        repos.delete(note)
    }

    fun getAllNotes(mailID: String): LiveData<List<NoteModel>> {
        return repos.getAllNotes(mailID)
    }
}