package com.example.mqtttestpro.mqtt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mqtttestpro.R
import kotlinx.android.synthetic.main.activity_main.*
import org.eclipse.paho.client.mqttv3.MqttMessage

//화면디자인 - 화면에 있는 위젯들의 이벤트에 반응하는 처리만 구현
class MqttTestActivity : AppCompatActivity(), View.OnClickListener {
    val server_uri = "tcp://172.30.1.19:1883" //브로커의 ip와 port
    var mymqtt : MyMqtt? = null
    val sub_topic = "iot/#"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mqtt통신을 수행할 Mqtt객체를 생성
        mymqtt = MyMqtt(this, server_uri)
        //브로커에서 메시지 전달되면 호출될 메소드를 넘기기
        //바이너리코드, 바이트코드를 직접 참조하도록 넘기는 것(::)
        mymqtt?.mysetCallback(::onReceived)
        //브로커연결
        mymqtt?.connect(arrayOf<String>(sub_topic))
        //이벤트 연결
        btn_led_on.setOnClickListener(this)
        btn_led_off.setOnClickListener(this)
        btn_open.setOnClickListener(this)
        btn_close.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var data:String=""
        if(v?.id == R.id.btn_led_on){
            data = "led_on"
            mymqtt?.publish("iot/led", data)
        }else if(v?.id == R.id.btn_led_off){
            data = "led_off"
            mymqtt?.publish("iot/led", data)
        }else if(v?.id == R.id.btn_open){
            data = "door_open"
            mymqtt?.publish("iot/servo", data)
        }else if(v?.id == R.id.btn_close){
            data = "door_close"
            mymqtt?.publish("iot/servo", data)
        }else{
            Toast.makeText(this, "what is it?", Toast.LENGTH_SHORT).show()
        }

    }
    //액티비티내부에 디자인된 위젯을 엑세스해야 하므로 외부 클래스에 있으면 액티비티의 구성요소를 접근하기 위해서 액티비티를 넘겨주어야 하는
    //번거로움을 없애기 위해 액티비티 내부에 메소드를 정의
    fun onReceived(topic:String, message:MqttMessage){
        //토픽의 수신을 처리
        //EditText에 내용을 출력하기, 영상으로 출력,...도착된 메시지 안에서 온도랑 습도 데이터를 이용해서 차트그래프
        //모션detect가 발생되면 Notification 발생,...
        val msg = String(message.payload)
        val msgdata = msg.split(":")
        when(msgdata[0]){
            "pir" -> showdata.append("침입자발생\n")
            "hc" -> showdata.append(msgdata[1]+"\n")
            "dht" -> showdata.append(msgdata[1]+"\n")
            else -> Log.d("mymqtt", "no data")
        }
        Log.d("mymqtt", msg)
    }
}
