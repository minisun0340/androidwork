package layout

import android.util.Log
import android.view.View
import android.widget.Toast

/*
* Click이벤트가 발생되면 View.OnClickListener객체의 onClick메소드가 자동으로 호출된다.
*                      -----------------------
*                      우리는 View.OnClickListener인터페이스를 상속받아 클래스를 정의하고
*                      onClick메소드를 오버라이딩해야 한다.
*/
class MyListener : View.OnClickListener {
    override fun onClick(v: View?) {
        Log.d("test", "click이벤트가 발생됨")
    }
}