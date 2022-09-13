package com.example.eco_project_20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Register_From : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_from)

        var queue = Volley.newRequestQueue(this)
        var name: EditText = findViewById(R.id.name_Re)
        var email: EditText = findViewById(R.id.email_re)
        var pass: EditText = findViewById(R.id.pass_re)
        var mobile: EditText = findViewById(R.id.mobile_re)
        var btn: Button = findViewById(R.id.button11)

        btn.setOnClickListener {
            val stringRequest = StringRequest(Request.Method.GET,
                "http://yashs.xyz/WebService1.asmx/insert?name="+name.text.toString()+"&email="+email.text.toString()+"&mobile="+mobile.text.toString()+"&password="+pass.text.toString(),
                { Response ->
                    Toast.makeText(applicationContext, "" + Response, Toast.LENGTH_SHORT).show()
                    var intent=Intent(applicationContext,Login_Page::class.java)
                    startActivity(intent)
                },
                {

                    Toast.makeText(applicationContext, "" + error(message = "sss"), Toast.LENGTH_SHORT).show()
                })
            queue.add(stringRequest)
        }

    }
}
