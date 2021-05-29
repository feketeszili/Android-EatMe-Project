package com.example.eatme.userInterface

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "ProfileDatabase"
val TABLE_NAME = "ProfileData"
val COL_NAME = "userName"
val COL_EMAIL = "email"
val COL_PHONE = "phone"
val COL_AGE = "age"
val COL_ADDRESS = "address"
val COL_ID = "id"

class DataBaseHandler(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " TEXT," +
                COL_EMAIL + "TEXT" +
                COL_PHONE + "INTEGER" +
                COL_AGE + "INTEGER" +
                COL_ADDRESS + " TEXT)"
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(profileData: ProfileData){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, profileData.userName)
        cv.put(COL_EMAIL, profileData.email)
        cv.put(COL_PHONE, profileData.phone)
        cv.put(COL_AGE, profileData.age)
        cv.put(COL_ADDRESS, profileData.address)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()

    }

    fun readData(): MutableList<ProfileData>{
        var list : MutableList<ProfileData> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var profileData = ProfileData()
                profileData.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                profileData.userName = result.getString(result.getColumnIndex(COL_NAME))
                profileData.email = result.getString(result.getColumnIndex(COL_EMAIL))
                profileData.phone= result.getString(result.getColumnIndex(COL_PHONE)).toInt()
                profileData.age=result.getString(result.getColumnIndex(COL_AGE)).toInt()
                profileData.address=result.getString(result.getColumnIndex(COL_EMAIL))
                list.add(profileData)
            }while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }
}