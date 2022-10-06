package com.example.datamanagement.sqlite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.datamanagement.R
import com.example.datamanagement.sqllite.DBHelper
import kotlinx.android.synthetic.main.dbjob_main.*

class DBTestMainActivity : AppCompatActivity() {
    var mydb:SQLiteDatabase? = null
    var imgdata = arrayOf(R.drawable.gong,R.drawable.jang,R.drawable.lee,R.drawable.so,R.drawable.jung)
    var imgname = arrayOf("공유","장기용","이민호","소지섭","정우성")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dbjob_main)
        //1. SQLiteOpenHelper의 객체를 생성
        var helper = DBHelper(this)
        //2. sQLiteDatabase객체를 생성
        mydb = helper.writableDatabase

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,imgname)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imgselect.adapter = adapter
        imgselect.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?,view: View?, position: Int, id: Long) {
                myimg.setImageResource(imgdata[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        save.setOnClickListener {
           val sql = """
               insert into mytable(id, name, age, img) values(?, ?, ?, ?)
              
           """.trimIndent()
            //sql문의 ?를 채울 값을 Array로 만들어서 순서대로 작업
            mydb?.execSQL(sql, arrayOf(id.text.toString(), name.text.toString(), age.text.toString(),
            imgdata[imgselect.selectedItemPosition]))
            Toast.makeText(this, "삽입 성공", Toast.LENGTH_SHORT).show()
        }
        /*//전체 레코드 조회
        find.setOnClickListener {
            val sql = "select * from mytable"
            val cursor:Cursor = mydb!!.rawQuery(sql, null)
            //조회한 Cursor객체에 저장된 레코드의 갯수를 조회
            val count = cursor.count
            //전체 레코드의 값을 Log로 출력해보기
            while(cursor.moveToNext()){ //다음 레코드로 포지션을 이동시키고 레코드가 있는지 true/false로 반환
                val idx = cursor.getInt(0)
                val id = cursor.getString(1)
                val name = cursor.getString(2)
                val age = cursor.getInt(3)
                val img = cursor.getInt(4)
                Log.d("test", "idx=>$idx, id=>$id, name=>$name, age=>$age, img=$img")
            }
            Toast.makeText(this, "조회된 레코드 갯수:$count", Toast.LENGTH_SHORT).show()

        }*/
        /*//조건 검색 여러개: age>=35
        find.setOnClickListener {
            val sql = "select * from mytable where age>=35"
            val cursor:Cursor = mydb!!.rawQuery(sql, null)
            //조회한 Cursor객체에 저장된 레코드의 갯수를 조회
            val count = cursor.count
            //전체 레코드의 값을 Log로 출력해보기
            while(cursor.moveToNext()){ //다음 레코드로 포지션을 이동시키고 레코드가 있는지 true/false로 반환
                val idx = cursor.getInt(0)
                val id = cursor.getString(1)
                val name = cursor.getString(2)
                val age = cursor.getInt(3)
                val img = cursor.getInt(4)
                Log.d("test", "idx=>$idx, id=>$id, name=>$name, age=>$age, img=$img")
            }
            Toast.makeText(this, "조회된 레코드 갯수:$count", Toast.LENGTH_SHORT).show()
        }*/
        //조건 검색 : 결과가 한 개만 레코드 조회하기
        find.setOnClickListener {
            val sql = "select * from mytable where id=?"
            val cursor = mydb!!.rawQuery(sql, arrayOf(id.text.toString()))
            //레코드가 한 개만 조회된다고 하더라도 포지션의 이동은 꼭 해야한다.
            if (cursor.moveToNext()){ //레코드로 포지션을 이동하고 레코드가 존재하면 true를 리턴
                id.setText(cursor.getString(1))
                name.setText(cursor.getString(2))
                age.setText(cursor.getString(3))
                myimg.setImageResource(cursor.getInt(4))
               }
            Toast.makeText(this, "조회된 레코드 갯수:${cursor.count}", Toast.LENGTH_SHORT).show()

        }
        update.setOnClickListener {
          var sql = """
              update mytable
              set age = ?
              where id =?
          """.trimIndent()
            mydb?.execSQL(sql, arrayOf(age.text.toString(), id.text.toString()))
            Toast.makeText(this, "업데이트 성공", Toast.LENGTH_SHORT).show()

        }
        
        del.setOnClickListener {
            var sql = "delete from mytable where id=?"
            mydb?.execSQL(sql, arrayOf(id.text.toString()))
            Toast.makeText(this, "삭제 성공", Toast.LENGTH_SHORT).show()

        }
    }
}