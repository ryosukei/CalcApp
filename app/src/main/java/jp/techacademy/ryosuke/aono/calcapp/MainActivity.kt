package jp.techacademy.ryosuke.aono.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        times.setOnClickListener(this)
        divide.setOnClickListener(this)
    }
    override fun onClick(v: View){
        if(edit1.text.toString().equals("")  || edit2.text.toString().equals("")){
            Log.d("null","null")
            Snackbar.make(v, "テキストエリアに数字を入力してください",Snackbar.LENGTH_INDEFINITE)
                .setAction("OK"){}.show()
            return
        }
        Log.d("notNull",edit1.text.toString())
        Log.d("notNull",edit2.text.toString())
        var edit1:Double = edit1.text.toString().toDouble()
        var edit2:Double = edit2.text.toString().toDouble()
        var result: Double = if(v.id == R.id.plus){
            edit1 + edit2
        }else if(v.id == R.id.minus){
            edit1 - edit2
        }else if(v.id == R.id.times){
            edit1 * edit2
        }else{
            edit1 / edit2
        }
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("result",result)
        startActivity(intent)
    }
}