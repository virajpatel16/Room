package com.example.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


interface mobileDao {

    @Insert
    fun insert(mobiledb:mobiledb)


    @Query("SELECT * FROM mobile")
    fun getmobile():List<mobiledb>

    @Delete
    fun  deletemobile(mobile: mobiledb)

    @Update
    fun updatemobile(mobile:mobiledb)

}