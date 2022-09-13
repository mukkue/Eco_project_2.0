package com.example.eco_project_20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class Login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        var queue= Volley.newRequestQueue(this)
        var email: EditText =findViewById(R.id.editTextTextEmailAddress3)
        var pass: EditText =findViewById(R.id.editTextTextPassword3)
        var btn1: Button =findViewById(R.id.button2)
        var btn2: Button =findViewById(R.id.button3)
        var btn3:Button=findViewById(R.id.button4)
        btn1.setOnClickListener {
            val stringRequest = StringRequest(
                Request.Method.GET,"http://yashs.xyz/WebService1.asmx/loginpage?email="+email.text.toString()+"&pass="+pass.text.toString(),
                { response ->

                    var jsonArray= JSONArray(response)
                    var jsonObject=jsonArray.getJSONObject(0)
                    var i=jsonObject.getString("msg")

                    if (i.equals("1")){
                        var intent= Intent(applicationContext,Home_page2::class.java)

                        startActivity(intent)
                        Toast.makeText(applicationContext, "Successfully Login", Toast.LENGTH_SHORT).show()

                    }
                    else{
                        Toast.makeText(applicationContext, "Invalid user id And Password", Toast.LENGTH_SHORT).show()
                    }
                  //  Toast.makeText(applicationContext, ""+response, Toast.LENGTH_SHORT).show()
                },
                {
                      Toast.makeText(applicationContext, "" + error(message = "sss"), Toast.LENGTH_SHORT).show()
                })
            queue.add(stringRequest)
        }
        btn2.setOnClickListener{

             var intent=Intent(applicationContext,Register_From::class.java)
             startActivity(intent)

        }
        btn3.setOnClickListener {

            var intent=Intent(applicationContext,Forget_Password::class.java)
            startActivity(intent)
        }


    }
}