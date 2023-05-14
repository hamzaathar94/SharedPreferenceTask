package com.example.sharedpreferencetask

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.text.set
import com.example.sharedpreferencetask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
  //  private var sharedPreferences:SharedPreferences?  =null
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

      var helper=MyDBHelper(applicationContext)
      var db=helper.readableDatabase
      var rs=db.rawQuery("SELECT * FROM USERS",null)
      if (rs.moveToNext())
          Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_LONG).show()
      val myPreference=MyPreference(this)

//        sharedPreferences=getSharedPreferences("Data", MODE_PRIVATE)
        binding?.button?.setOnClickListener {

            myPreference.putString("name",binding?.edtxtname?.text.toString())
            myPreference?.putString("email",binding?.edtxtemail?.text.toString())
            myPreference.putInt("age",binding?.edtxtage?.text.toString().toInt())

//          val editor=sharedPreferences?.edit()
//
//            editor?.putString("name",binding?.edtxtname?.text.toString())
//            editor?.putString("email",binding?.edtxtemail?.text.toString())
//            editor?.putInt("age",binding?.edtxtage?.text.toString().toInt())
//
//
//            editor?.apply()

            binding?.edtxtname?.text?.clear()
            binding?.edtxtemail?.text?.clear()
            binding?.edtxtage?.text?.clear()
        }

        binding?.button2?.setOnClickListener {

            binding?.edtxtname?.setText(myPreference?.setString("name",""))
            binding?.edtxtemail?.setText(myPreference?.setString("email",""))
            binding?.edtxtage?.setText(myPreference.setInt("age",0).toString())
//           val uname= myPreference?.setString("name","")
//            val em=myPreference?.setString("email","")
//            val ag=myPreference?.setInt("age",0)
//            Log.d("Name:",uname.toString())
//            Log.d("Email:",em.toString())
//            Log.d("Age:",ag.toString())
//            val editor=sharedPreferences?.edit()
//            editor?.clear()
//            editor?.apply()

//            binding?.edtxtname?.text?.clear()
//            binding?.edtxtemail?.text?.clear()
//            binding?.edtxtage?.text?.clear()
        }
      binding?.button3?.setOnClickListener {
          var cv=ContentValues()
          cv.put("NAME",binding?.edtxtname?.text?.toString())
          cv.put("EMAIL",binding?.edtxtemail?.text?.toString())
          cv.put("AGE",binding?.edtxtage?.text?.toString())
          db.insert("USERS",null,cv)

          binding?.edtxtname?.setText("")
          binding?.edtxtemail?.setText("")
          binding?.edtxtage?.setText("")

      }

      binding?.button4?.setOnClickListener {
          Toast.makeText(this, "I'm clicked", Toast.LENGTH_SHORT).show()
//          binding?.edtxtname?.setText(rs.getString(1))
//          binding?.edtxtemail?.setText(rs.getString(2))
//          binding?.edtxtage?.setText(rs.getString(3))

      }
    }

    override fun onResume() {
        super.onResume()


//        sharedPreferences=getSharedPreferences("Data", MODE_PRIVATE)
//
//        //val nm=sharedPreferences?.getString("name","")
//       // Toast.makeText(this,""+nm,Toast.LENGTH_LONG).show()
//       // binding?.edtxtname?.setText(nm)
//
//        binding?.edtxtname?.setText(sharedPreferences?.getString("name",""))
//
//        binding?.edtxtemail?.setText(sharedPreferences?.getString("email",""))
//
//        binding?.edtxtage?.setText(sharedPreferences?.getInt("age",0)?.toString())
    }

//    override fun onDestroy() {
//        super.onDestroy()
//
//        sharedPreferences=getSharedPreferences("Data", MODE_PRIVATE)
//        val ed=sharedPreferences?.edit()
//        ed?.clear()
//        ed?.apply()
//        binding?.edtxtname?.setText("")
//        binding?.edtxtemail?.setText("")
//        binding?.edtxtage?.setText("")
//    }

}
