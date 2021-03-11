package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //When two inserted data has same data,then what action it should take
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

}