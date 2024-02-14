package com.agworks.internshala.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.agworks.internshala.entity.NoteModel


@Dao
interface NoteDAO {
    @Insert
    suspend fun insert(note: NoteModel)

    @Update
    fun update(note: NoteModel)

    @Delete
    suspend fun delete(note: NoteModel)

    @Query("SELECT * from notes_table where mail = :mailID order by id DESC")
    fun getAllNotes(mailID:String): LiveData<List<NoteModel>>
}