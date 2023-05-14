package com.example.sharedpreferencetask

import android.content.Context
import android.content.SharedPreferences
import android.view.Display.Mode

class MyPreference(context: Context) {
    private var sharedPreferences: SharedPreferences=
        context.getSharedPreferences("Data",Context.MODE_PRIVATE)


    fun putString(key:String,value:String){
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun setString(key: String,value: String):String?{
        return sharedPreferences.getString(key,value)
    }

    fun putInt(key: String,value:Int){
        sharedPreferences.edit().putInt(key,value).apply()
    }

    fun setInt(key: String,value: Int):Int{
        return sharedPreferences.getInt(key,value)
    }

    fun clearAll(){
        with(sharedPreferences.edit()){
            clear()
            apply()
        }
    }

}