package com.example.mqtttestpro.http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import com.example.mqtttestpro.R
import kotlinx.android.synthetic.main.activity_http_test.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class HttpTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_test)
        button.setOnClickListener {
            //http요청은 네트워크 작업이므로 쓰레드로 작성한다.
            thread{
                //접속할 주소를 내부에서 인식할 수 있는 URL객체로 생성
                val site = "http://172.30.1.56:8000/list/"
                val url = URL(site)

                //http요청 - http요청할 수 있는 객체를 생성하기
                val con = url.openConnection() as HttpURLConnection
                //접속하고 싶은 주소에 접속해서 모든 resource를 읽어오기
                //InputStreamReader는 바이트 데이터를 읽을 수 있는 기능을 갖고 있는 객체
                //네트워로 전송되는 데이터 = 바이트배열
                //con.inputStream => "http://172.30.1.56:8000/list/"에 연결해서 데이터를 읽을 수 있는 객체-네트워크연결데이터 = 원시데이터
                //데이터 읽을 수 있는 역할을 하는 객체를 만들기
                val inputStream = InputStreamReader(con.inputStream, "UTF-8") //한글은 2byte, 그러므로 깨진다 그거를 보안하기 위해서 인풋스트림리더을 사용
                val br = BufferedReader(inputStream) //한글자씩 말고 라인씩 읽는거. 빠름
                var str:String? = null //http://172.30.1.56:8000/list/에 접속해서 데이터를 한 줄 읽어서 읽은 데이터를 저장할 변수
                val buf = StringBuffer() //String과 동일하나 리소스를 적게 사용함 - 성능이 우수
                //http요청으로 받은 데이터를 한 줄씩 읽어서 buf에 추가
                do{
                    str = br.readLine()
                    if(str!=null){
                        buf.append(str)
                    }
                }while(str!=null)  //-------------------------//http://172.30.1.56:8000/list/가 최종적으로 리턴하는 json데이터를 얻을 수 있다.
                Log.d("http", buf.toString())

                //반환된 JSON Array에 담겨있는 JSON Object를 꺼내서 예쁘게 뿌리기
                val data = buf.toString()
                val root = JSONArray(data)
                //JSONArray에 담긴 데이터 갯수만큼 반복 작업
                for (i in 0 until root.length()){
                    //i번째 JSON객체를 추출
                    var jsondata = root.getJSONObject(i)
                    //꺼낸 JSONObject를 BoardData로 변환
                    var modeldata = BoardData(jsondata.getInt("boardNo"),
                        jsondata.getString("title"), jsondata.getString("content"), jsondata.getString("writer"),
                        jsondata.getString("write_date"))
                    //변환한 데이터를 TextView에 출력하기
                    runOnUiThread {
                        textView2.append(modeldata.toString()+"\n")
                    }
                }
            }
        }
    }
}