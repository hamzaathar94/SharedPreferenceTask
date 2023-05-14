package com.example.sharedpreferencetask

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context):SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,EMAIL TEXT, AGE TEXT)")
       // db?.execSQL("INSERT INTO USERS(NAME,EMAIL,AGE) VALUES('Ali','a@gmail.com','30')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS USERS")
        onCreate(db)
    }
}