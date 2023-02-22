package com.example.room

import android.content.Context
import androidx.room.*
import androidx.room.Room


@Database(entities = [mobiledb::class], version = 0)
abstract class mobile: RoomDatabase() {


  companion object{
      fun getInstance(context: Context): mobile {
          var db=Room.databaseBuilder(context,mobile::class.java,"shop")
              .allowMainThreadQueries()
              .fallbackToDestructiveMigration()
              .build()
          return db

      }
  }
    abstract fun mobile():mobileDao

}