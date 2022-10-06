package com.example.datamanagement.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

const val DB_VERSION =2
class DBHelper:SQLiteOpenHelper {
    //test.db파일의 형태로 데이터가 저장된다.
    //부모생성자 내부에서 데이터베이스를 오픈하고 사용할 수 있는 상태로 만드는 작업을 실행
    constructor(context: Context):super(context, "test.db", null, DB_VERSION)

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("test", "데이터베이스가 생성되었습니다.")
        val sql = """
            create table mytable(
            idx integer primary key autoincrement,
            id text,
            name text,
            age integer,
            img integer
            )
            
        """.trimIndent()
        //sql문을 실행
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("test", "onUpgrade:$oldVersion -> $newVersion")
        when(oldVersion){
            1->{
                // 1->2버전으로 변경된 경우
            }
            2->{
                // 2->3버전으로 변경된 경우
            }
        }
    }
}