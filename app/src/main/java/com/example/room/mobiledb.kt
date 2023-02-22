package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile")
class mobiledb(

    @ColumnInfo(name = "name") var name:String,

    @ColumnInfo(name="price") var price: Int,
    @ColumnInfo(name = "rating") var rating: Float)




{
    @PrimaryKey (autoGenerate = true)@ColumnInfo(name = "id") var id: Int=0




}
